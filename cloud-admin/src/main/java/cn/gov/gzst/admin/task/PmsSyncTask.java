package cn.gov.gzst.admin.task;

import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.admin.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.task
 * @title:
 * @description: 项目管理系统用户信息同步
 * @author: jianliaoliang
 * @date: 2018/6/13 15:12
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
// @Component("PmsSyncTask")
public class PmsSyncTask {

    private final String pmsUrl = "http://xmgl.gzst.gov.cn";
    private final String findAllUserUrl =pmsUrl + "/pms/findAllUser.do";
    private final String findByIdUrl = pmsUrl + "/pms/findById.do";
    private RestTemplate restTemplate = new RestTemplate();
    private List<String> userList = new ArrayList<>();
    private Boolean isRun=Boolean.FALSE;
    public final Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private IUserService userService;

    /**
     * 项目管理系统用户信息同步
     */
    @PostConstruct
    public  void initPmsSyncTask(){
        try {
            userList.clear();
            // 获得已处理列表
            List<String> alreadyUserIdList = new ArrayList<>();
            List<User> alreadyUserList = userService.selectList(new EntityWrapper<User>().setSqlSelect("pms_uid"));
            for (User user: alreadyUserList) {
                if (user!=null) {
                   // alreadyUserIdList.add(user.getPmsUid());
                }
            }
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(this.findAllUserUrl, String.class);
            String body = responseEntity.getBody();
            log.info(" 返回用户ID......................................" + body);
            List<Map> userList = JSONArray.parseArray(body,Map.class);
            for (Map map:userList) {
                if (!alreadyUserIdList.contains(map.get("id"))){
                   this.userList.add(map.get("id")+"");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 检查回复并写入到日志中
     */
    @Scheduled(fixedRate = 10000)
    public void run() {
        log.info(" 用户采集开始......................................" + (new Date()));
        if (!isRun) {
            initPmsSyncTask();
            List<String> alreadyUserIdList = new ArrayList<>();
            try {
                for (String uid:userList) {
                    //账号重复
                    if (userService.selectCount(new EntityWrapper<User>().eq("pms_uid",uid))>0){
                        continue;
                    }
                    Map<String,String> uriVariables=new HashMap<String,String>();
                    uriVariables.put("uid",uid);
                    ResponseEntity<String> responseEntity = restTemplate.getForEntity(this.findByIdUrl+"?id={uid}", String.class,uriVariables);
                    String body = responseEntity.getBody();
                    log.info("用户信息:" + body);
                    //userService.saveOldUser(body);
                    alreadyUserIdList.add(uid);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                isRun = Boolean.FALSE;
                userList.removeAll(alreadyUserIdList);
            }
        }
    }
}
