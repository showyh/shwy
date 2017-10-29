package shwy.tk.pojo.vo;

import java.util.List;

/**
 * Created by shwy on 2017/10/20.
 */
public class TimeLineVO {

    private String moodArchiveDate;
    List<MoodVO> moodVOList;

    public String getMoodArchiveDate() {
        return moodArchiveDate;
    }

    public void setMoodArchiveDate(String moodArchiveDate) {
        this.moodArchiveDate = moodArchiveDate;
    }

    public List<MoodVO> getMoodVOList() {
        return moodVOList;
    }

    public void setMoodVOList(List<MoodVO> moodVOList) {
        this.moodVOList = moodVOList;
    }
}
