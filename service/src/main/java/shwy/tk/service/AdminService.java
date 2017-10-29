package shwy.tk.service;

import shwy.tk.pojo.po.AdminPO;
import shwy.tk.pojo.po.LoginHistoryPO;

/**
 * Created by shwy on 2017/10/18.
 */
public interface AdminService {

    AdminPO checkLogin(AdminPO adminPO);

    int addLoginHistory(LoginHistoryPO loginHistoryPO);

    LoginHistoryPO getLoginHistory();

    AdminPO getAdminPOByUserName(String userName);

    int updateAdmin(AdminPO adminPO);


}
