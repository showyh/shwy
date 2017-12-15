package shwy.tk.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import shwy.tk.pojo.po.AdminPO;
import shwy.tk.service.AdminService;

/**
 * Created by shwy on 2017/10/17.
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;


    //权限设置
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份设置
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        AdminPO adminPO=adminService.getAdminPOByUserName(userName);
        if(adminPO!=null){
            SecurityUtils.getSubject().getSession().setAttribute("currentAdmin", adminPO);
            //设置session超时时间1h。
            SecurityUtils.getSubject().getSession().setTimeout(3600000);
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(adminPO.getUserName(),adminPO.getPassword(),"xx");
            return authcInfo;
        }else{
            return null;
        }
    }
}
