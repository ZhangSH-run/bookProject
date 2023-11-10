package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("login.html")
    public String loginHtml(){
        return "user/login";
    }
    @RequestMapping("regist.html")
    public String registHtml(){
        return "user/regist";
    }
}
