package cn.gov.gzst.assessment.controller;

import cn.gov.gzst.assessment.entity.EvalProcess;
import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.entity.EvalSelfResult;
import cn.gov.gzst.assessment.entity.PactProjectbase;
import cn.gov.gzst.assessment.service.IEvalProcessService;
import cn.gov.gzst.assessment.service.IEvalProcesslastService;
import cn.gov.gzst.assessment.service.IEvalSelfResultService;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
import cn.gov.gzst.pms.feign.PactProjectBaseFeign;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.common.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-19
 */
@Api(value="自评结果表controller-------",tags={"自评表结果-----"})
@Controller
@RequestMapping("jxpgSelfResult")
public class EvalSelfResultController extends BaseBeanController<EvalSelfResult> {
    @Autowired
    private IEvalSelfResultService iEvalSelfResultService;
    @Autowired
    private IEvalProcessService iEvalProcessService;
    @Autowired
    private IEvalProcesslastService iEvalProcesslastService;

    @Autowired
   private PactProjectBaseFeign pactProjectBaseFeign;





    /**
     * 某一个用户查询提交的记录
     * @param
     * @return
     */
    @ApiOperation("管理员查看已提交列表")
    @GetMapping("adminFindListTODO")
    @ResponseBody
    public PageInfo adminFindListTODO(
            @RequestParam(name = "page",required=true,defaultValue = "1") int page,
            @RequestParam(name = "size",required=true,defaultValue = "10") int size){
        List<Map<String,Object>> todolist =
                iEvalSelfResultService.adminFindListTodo(page,size);






        //本地查出待审核列表，并取出每一项的pactid加到list中，传到服务器端去调用
      /*  List<String>  pactidlist = new ArrayList<>();
        List<EvalProcesslast>  adminlisttodo =  iEvalSelfResultService.adminFindListtodoone(page,size);
        for (EvalProcesslast ep: adminlisttodo) {
            pactidlist.add(ep.getPactid());
        }
        pactidlist.add("7354858164022271049281320");
        System.out.println("-----------:"+pactidlist);
        List<Map<String,Object>>  pactbase =  pactProjectBaseFeign.adminFindList(pactidlist);
        List list1 = new ArrayList();
        StringBuffer buf=new StringBuffer("");
        for (int i = 0;i<adminlisttodo.size();i++){
            for (int j = 0;j<pactbase.size();j++){
                if (pactbase.get(j).containsValue(adminlisttodo.get(i).getPactid())){

                    buf.append(adminlisttodo.get(i).toString().substring(15,adminlisttodo.get(i).toString().length()-1)).append(",");
                    buf.append(pactbase.get(j).toString().substring(1));
                    list1.add(buf);
                }
            }
        }
*/






        PageInfo todopageInfo = new PageInfo(todolist);
        System.out.println("pageinfo1:"+todopageInfo);

        return todopageInfo;
    }






    @ApiOperation("管理员查看已审核列表")
    @GetMapping("adminFindListDone")
    @ResponseBody
    public PageInfo adminFindListDone(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "size",defaultValue = "10") int size){
        List<Map<String,Object>> donelist =iEvalSelfResultService.adminFindListDone(page,size);
        PageInfo todopageInfo = new PageInfo(donelist);
        return todopageInfo;
    }


    @PostMapping("adminCkeck")
    @ApiOperation("管理员审批接口")
    @ResponseBody
    public ResponseResult adminCkeck(){
        ResponseResult responseResult = new ResponseResult();
        String pactid = request.getParameter("pactid");
        String opinion = request.getParameter("opinion");
        String passornot = request.getParameter("passOrnot");
        String userid = request.getParameter("userid");
        String id = request.getParameter("id");

        System.out.println(id);

        int rows = iEvalProcessService.checkfinish(pactid);
        if(rows<0){
            return responseResult.ok("操作失败！");
        }
        int passornotone = Integer.parseInt(passornot);
            EvalProcess evalProcess = new EvalProcess();
            evalProcess.setOpinion(opinion);
            evalProcess.setPactid(pactid);
            evalProcess.setOperator(userid);
            evalProcess.setState(passornotone);
            evalProcess.setOperateTime(new Date());
            evalProcess.setIscheck(1);
            iEvalProcessService.saveOrUpdate(evalProcess);

            EvalProcesslast evalProcesslast = new EvalProcesslast();
             evalProcesslast.setId(id);
            evalProcesslast.setOpinion(opinion);
            evalProcesslast.setPactid(pactid);
            evalProcesslast.setOperator(userid);
            evalProcesslast.setState(passornotone);
            evalProcesslast.setOperateTime(new Date());
            evalProcesslast.setIscheck(1);
             iEvalProcesslastService.saveOrUpdate(evalProcesslast);



        return  responseResult.ok("保存成功！");


    }


    /**
     * 某一个用户查询提交的记录
     * @param userid
     * @return
     */
    @ApiOperation("用户查询已申报合同记录")
    @GetMapping("{userid}/userFindList")
    @ResponseBody
    public List<Map<String,Object>> userFindList(@PathVariable("userid") String userid){
        List<Map<String,Object>> userlist = iEvalSelfResultService.userFindList(userid);
        for(Map users : userlist) {
            boolean isexist =  users.containsKey("state");
            System.out.println(isexist);
            if (!isexist){
                users.put("state",0);
            }

        }
        return userlist;

    }

}
