package shwy.tk.dao;

import shwy.tk.pojo.vo.MoodVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/17.
 */
public interface MoodDAO {

    List<MoodVO> listMoodVO(HashMap<String, String> param);

    List<String> listMoodArchiveDate();

}
