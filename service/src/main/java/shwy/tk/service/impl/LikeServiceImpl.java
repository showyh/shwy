package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.LikeDAO;
import shwy.tk.service.LikeService;
import shwy.tk.utils.DateUtil;
import shwy.tk.utils.StringUtil;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public Long getLikeCount() {
        return likeDAO.getLikeCount();
    }

    @Override
    public int addLike(String userIP) {
        return likeDAO.addLike(userIP);
    }

    @Override
    public Long getTodayLike() {
        String todayDateStr = DateUtil.getTodayDateStr();
        String today = StringUtil.formatLikeSQL(todayDateStr);
        return likeDAO.getTodayLike(today);
    }
}
