package example.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.domain.User;
import example.service.UserService;

import java.util.Date;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.html")
    public String loginPage() {
        return "login";
    }


    @RequestMapping(value = "/loginCheck.html")
    public String loginCheck(HttpServletRequest request, @Valid LoginInfo loginInfo, Errors errors, Model model)  throws Exception {
        if(errors.hasErrors()){
            String errorMessage1="";
            String errorMessage2="";
            Error error;
            if(errors.getFieldErrorCount()==2){
                errorMessage1=errors.getFieldError("userName").getDefaultMessage();
                errorMessage2=errors.getFieldError("password").getDefaultMessage();
                error = new Error(errorMessage1 + "\n" + errorMessage2);
            }else{
                errorMessage1=errors.getFieldError().getDefaultMessage();
                error = new Error(errorMessage1);
            }
            model.addAttribute(error);
            return "login";
        }
        boolean isValidUser =
                userService.hasMatchUser(loginInfo.getUserName(),
                        loginInfo.getPassword());
        if (!isValidUser) {
            model.addAttribute(new Error("Incorrect username or password"));
            return "login";
        } else {
            User user = userService.findUserByUserName(loginInfo
                    .getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.saveLog(user);
            request.getSession().setAttribute("user", user);
            return "main";
        }
    }
}
