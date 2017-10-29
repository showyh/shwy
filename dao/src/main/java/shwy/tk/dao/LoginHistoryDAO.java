package shwy.tk.dao;

import shwy.tk.pojo.po.LoginHistoryPO;

/**
 * Created by shwy on 2017/10/17.
 */
public interface LoginHistoryDAO {

    int addLoginHistory(LoginHistoryPO loginHistoryPO);

    LoginHistoryPO getLoginHistory();
}
