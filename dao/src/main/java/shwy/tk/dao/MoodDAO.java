package shwy.tk.dao;

import shwy.tk.pojo.po.MoodPO;
import shwy.tk.pojo.vo.MoodVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/17.
 */
public interface MoodDAO {

    List<MoodVO> listMoodVO(HashMap<String, String> param);

    List<String> listMoodArchiveDate();
    List<MoodPO> listMoodPO(HashMap<String, Object> param);

    Long getMoodCount();

    int updateMood(MoodPO moodPO);

    int addMood(MoodPO moodPO);

}
