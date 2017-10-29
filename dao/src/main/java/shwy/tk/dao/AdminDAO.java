package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.AdminPO;

/**
 * Created by shwy on 2017/10/17.
 */
public interface AdminDAO {

    AdminPO checkLogin(AdminPO adminPO);

    AdminPO getAdminPOByUserName(@Param("userName") String userName);

    int updateAdmin(AdminPO adminPO);
}
