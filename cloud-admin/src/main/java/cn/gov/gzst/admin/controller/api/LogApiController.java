package cn.gov.gzst.admin.controller.api;

import cn.gov.gzst.admin.entity.Log;
import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.admin.service.ILogService;
import cn.gov.gzst.admin.service.IUserService;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.utils.IpUtils;
import cn.gov.gzst.common.utils.security.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志数据API控制器
 */
@Controller
@RequestMapping("logApi")
public class LogApiController extends BaseBeanController<Log> {

    @Autowired
    private ILogService logService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Log log) {
        String userId = this.getCurrentUserId();
        User user = userService.selectById(userId);
        log.setCreateBy(user);
        try {
            logService.insert(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}