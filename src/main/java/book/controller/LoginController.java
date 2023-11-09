package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("login.html")
    public String loginHtml(){
        return "user/login";
    }
    @GetMapping("regist.html")
    public String registHtml(){
        return "user/regist";
    }
}
