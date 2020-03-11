package cn.gov.gzst.admin.controller.api;

import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.admin.service.IUserService;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据API控制器
 */
@Controller
@RequestMapping("userApi")
public class UserApiController extends BaseBeanController<User> {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "checkUser/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    @Login(action = Action.Skip)
    public Boolean checkUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.checkUser(username, password);
    }

    @Login(action = Action.Skip)
    @RequestMapping(value = "findByUsername/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @Login(action = Action.Skip)
    @RequestMapping(value = "findByUserId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findByUserId(@PathVariable("id") String id) {
        return userService.findByUserId(id);
    }

    @RequestMapping(value = "findAuthes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SecAuthority> findByAuthById(@PathVariable("id") String id) {
        return userService.findAuthById(null,id);
    }

    @RequestMapping(value = "findListByIds", method = RequestMethod.POST)
    @ResponseBody
    public List<User> findListByIds(String[] ids) {
        ArrayList<String> idList = new ArrayList<String>();
        for (String id : ids) {
            idList.add(id);
        }
        return userService.selectBatchIds(idList);
    }
}