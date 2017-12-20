package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.AdminDAO;
import shwy.tk.dao.LoginHistoryDAO;
import shwy.tk.pojo.po.AdminPO;
import shwy.tk.pojo.po.LoginHistoryPO;
import shwy.tk.service.AdminService;

/**
 * @author showy on 2017/10/17.
 * @version 1.0
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private LoginHistoryDAO loginHistoryDAO;

    @Override
    public AdminPO checkLogin(AdminPO adminPO) {
        return adminDAO.checkLogin(adminPO);
    }

    @Override
    public int addLoginHistory(LoginHistoryPO loginHistoryPO) {
        return loginHistoryDAO.addLoginHistory(loginHistoryPO);
    }

    @Override
    public LoginHistoryPO getLoginHistory() {
        return loginHistoryDAO.getLoginHistory();
    }

    @Override
    public AdminPO getAdminPOByUserName(String userName) {
        return adminDAO.getAdminPOByUserName(userName);
    }

    @Override
    public int updateAdmin(AdminPO adminPO) {
        return adminDAO.updateAdmin(adminPO);
    }

}
