package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.AdminPO;

/**
 * @author showy on 2017/10/17.
 * @version 1.0
 */
public interface AdminDAO {

    AdminPO checkLogin(AdminPO adminPO);

    AdminPO getAdminPOByUserName(@Param("userName") String userName);

    int updateAdmin(AdminPO adminPO);
}
