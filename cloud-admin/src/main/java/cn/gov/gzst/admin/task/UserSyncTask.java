package cn.gov.gzst.admin.task;


import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.admin.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * 同步用户信息
 * @author wuzhengjun
 */

//@Component("UserSyncTask")
public class UserSyncTask {
    private Integer page;   //当前页
    private Integer rows;   //每页显示数据记录
    private Integer total;       //记录总数
    private Integer totalPage;   //总页数
    private String token="c654b9bb61b34b868c18a10dc461e9d6";
    private final String userUrl = "http://192.168.10.73:8080/api/kjy/alluser.do"+"?page={page}&rows={rows}&token={token}";
    private RestTemplate restTemplate = new RestTemplate();
    private List<String> userList = new ArrayList<>();
    private Boolean isRun = Boolean.FALSE;
    public final Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private IUserService userService;

    /**
     * 检查回复并写入到日志中
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void run() {
        log.info(" 用户采集开始......................................" + (new Date()));
           if(!isRun){
               if(rows == null){
                   rows = 20;
               }
               if(page == null){
                   page = 1;
               }
               try {
                   ResponseEntity<String> rs = restTemplate.getForEntity(this.userUrl, String.class,page,rows,token);
                   String strBody = rs.getBody();
                   log.info("用户信息:运行" );
                   JSONObject jbt = JSONObject.parseObject(strBody);
                   total = jbt.getInteger("total");
                   if(total%rows == 0){
                       totalPage = total/rows;
                   }else{
                       totalPage = total/rows + 1;
                   }
                   for(page = 1;page <= totalPage;page++){
                       Thread.currentThread().sleep(2000);//2000毫秒延时
                       ResponseEntity<String> responseEntity = restTemplate.getForEntity(this.userUrl, String.class,page,rows,token);
                       String body = responseEntity.getBody();
                       JSONObject json = JSONObject.parseObject(body);
                       Boolean code = json.getBoolean("code");
                       if(!code){
                           log.info(json.getString("msg"));
                           continue;
                       }
                       JSONArray jsonArray = JSONArray.parseArray(json.getString("data"));
                       for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
                            JSONObject jsonObject = (JSONObject) iterator.next();
                            log.info(jsonObject.toJSONString());
                            String idcard = jsonObject.getString("idcard");
                            User user = JSONObject.parseObject(jsonObject.toJSONString(),User.class);
                            if(!StringUtils.isEmpty(idcard)){
                                User idcardUser = userService.selectOne(new EntityWrapper<User>().eq("idcard",idcard));
                                if (idcardUser != null){
                                  user = idcardUser;
                                }else{
                                  userService.insert(user);
                                }
                            }
                       }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               } finally {
                   isRun = Boolean.FALSE;
               }
           }
    }
}
