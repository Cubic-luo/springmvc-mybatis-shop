package shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.entity.Order;
import shop.entity.User;
import shop.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String showRegister(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        userService.register(user);
        return "redirect:/";
    }

    /**
     * 前端验证用户名是否存在
     *
     * @param username
     */
    @RequestMapping(value = "/register/checkUsername", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username) {
        return userService.checkUsername(username);
    }
    /**
     * 转到用户注册页面
     *
     * @return
     */
    @RequestMapping(value = "/showRegister")
    public String showRegister() {
        return "register";
    }

    /**
     * 转到我的订单页面
     *
     * @return
     */
    @RequestMapping(value = "/orders")
    public String showOrders(Model model) {
        List<Order> orderList = userService.showOrders();
        model.addAttribute("orderList", orderList);
        return "myOrder";
    }

    /**
     * 转到个人中心
     *
     * @return
     */
    @RequestMapping(value = "/center")
    public String showCenter(Model model) {
        User user = userService.showUser();// 当前登录用户的信息
        model.addAttribute("user", user);
        return "center";
    }
}
