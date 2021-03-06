package shwy.tk.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import shwy.tk.pojo.po.AdminPO;
import shwy.tk.pojo.po.LoginHistoryPO;
import shwy.tk.service.AdminService;
import shwy.tk.utils.ConfigStrUtil;

import javax.servlet.http.HttpSession;

/**
 * @author showy on 2017/10/17.
 * @version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;



    @RequestMapping(value="/background",method = RequestMethod.GET)
    public String goBackground(){
        return "background/index";
    }

    @RequestMapping(value ="/login",method = RequestMethod.GET)
    @ResponseBody
    public String checkLogin(AdminPO adminPO, LoginHistoryPO loginHistoryPO, HttpSession session){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(adminPO.getUserName(), adminPO.getPassword());
        try{
            subject.login(token);//登录验证
            session.setAttribute("currentAdmin",adminPO);
            int result=adminService.addLoginHistory(loginHistoryPO);
            if(result>0){
                session.setAttribute("currentAdmin",adminPO);
                return ConfigStrUtil.SUCCESS;
            }else{
                return ConfigStrUtil.ERROR;
            }
        }catch(Exception e){
            e.printStackTrace();
            return ConfigStrUtil.ERROR;
        }

    }
}
