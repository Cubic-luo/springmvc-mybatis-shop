package shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/5.
 * 管理页面control类
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    //跳转到管理页面
    @RequestMapping()
    public String manage(Model model){
        return "manage";
    }
}
