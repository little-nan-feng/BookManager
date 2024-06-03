package contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginCheck")
    public String loginCheck(User user, HttpServletRequest request){

        User user1=userService.queryUser(user);

        if(user1!=null){
            request.getSession().setAttribute("USER_SESSION",user1);
            return "redirect:/main";
        }
        else {
            request.setAttribute("msg","账号、密码或身份信息错误...");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
