package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.VisitorDAO;
import shwy.tk.pojo.po.VisitorPO;
import shwy.tk.service.VisitorService;
import shwy.tk.utils.DateUtil;
import shwy.tk.utils.StringUtil;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDAO visitorDAO;

    @Override
    public int addVisitor(VisitorPO visitorPO) {
        return visitorDAO.addVisitor(visitorPO);
    }

    @Override
    public Long getReadNum() {
        return visitorDAO.getReadNum();
    }

    @Override
    public Long getTodayReadNum() {
        String todayDateStr = DateUtil.getTodayDateStr();
        String today = StringUtil.formatLikeSQL(todayDateStr);
        return visitorDAO.getTodayReadNum(today);
    }
}
