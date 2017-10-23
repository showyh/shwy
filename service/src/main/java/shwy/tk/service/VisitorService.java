package shwy.tk.service;

import shwy.tk.pojo.po.VisitorPO;

/**
 * Created by shwy on 2017/4/17.
 */
public interface VisitorService {

    int addVisitor(VisitorPO visitorPO);

    Long getReadNum();

    Long getTodayReadNum();
}
