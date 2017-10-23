package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.VisitorPO;

/**
 * Created by shwy on 2017/10/23.
 */
public interface VisitorDAO {

    int addVisitor(VisitorPO visitorPO);

    Long getReadNum();

    Long getTodayReadNum(@Param("today") String today);
}
