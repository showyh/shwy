package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MoodDAO;
import shwy.tk.pojo.po.MoodPO;
import shwy.tk.pojo.vo.MoodVO;
import shwy.tk.pojo.vo.TimeLineVO;
import shwy.tk.service.TimeLineService;
import shwy.tk.utils.DateUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("timeLineService")
public class TimeLineServiceImpl implements TimeLineService {

    @Autowired
    private MoodDAO moodDAO;

    @Override
    public List<TimeLineVO> listTimeLine() {
        List<TimeLineVO> timeLineVOList = new ArrayList<>();
        //获取所有月份集合
        List<String> moodArchiveDateList = moodDAO.listMoodArchiveDate();
        //在数据库最大月份后再增加一个月，添加在0的位置
        String dateAdd = DateUtil.getMouthAdd(moodArchiveDateList.get(0));
        moodArchiveDateList.add(0, dateAdd);
        int size = moodArchiveDateList.size();
        //遍历到size-2，去除数据库最小月份
        for (int i = 0; i <= size - 2; i++) {
            TimeLineVO timeLineVO = new TimeLineVO();
            //取出月份内的数据
            HashMap<String, String> param = new HashMap<>();
            param.put("startDate", moodArchiveDateList.get(i + 1));
            param.put("endDate", moodArchiveDateList.get(i));
            List<MoodVO> moodVOList = moodDAO.listMoodVO(param);
            //添加当前月份
            timeLineVO.setMoodArchiveDate(moodArchiveDateList.get(i));
            timeLineVO.setMoodVOList(moodVOList);

            timeLineVOList.add(timeLineVO);
        }
        return timeLineVOList;
    }

    @Override
    public List<MoodPO> listMoodPO(HashMap<String, Object> param) {
        List<MoodPO> moodList = moodDAO.listMoodPO(param);
        return moodList;
    }

    @Override
    public Long getMoodCount() {
        return moodDAO.getMoodCount();
    }

    @Override
    public int updateMood(MoodPO moodPO) {
        return moodDAO.updateMood(moodPO);
    }

    @Override
    public int addMood(MoodPO moodPO) {
        return moodDAO.addMood(moodPO);

    }
}
