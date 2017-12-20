package shwy.tk.service;

import shwy.tk.pojo.po.AdminPO;
import shwy.tk.pojo.po.LoginHistoryPO;

/**
 * @author showy on 2017/10/17.
 * @version 1.0
 */
public interface AdminService {

    AdminPO checkLogin(AdminPO adminPO);

    int addLoginHistory(LoginHistoryPO loginHistoryPO);

    LoginHistoryPO getLoginHistory();

    AdminPO getAdminPOByUserName(String userName);

    int updateAdmin(AdminPO adminPO);


}
