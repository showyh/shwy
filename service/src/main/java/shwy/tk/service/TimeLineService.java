package shwy.tk.service;

import shwy.tk.pojo.po.MoodPO;
import shwy.tk.pojo.vo.TimeLineVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/18.
 */
public interface TimeLineService {

    List<TimeLineVO> listTimeLine();

    List<MoodPO> listMoodPO(HashMap<String, Object> param);

    Long getMoodCount();

    int updateMood(MoodPO moodPO);

    int addMood(MoodPO moodPO);

    int deleteMood(Integer id);

    MoodPO getMood(Integer id);
}
