package shwy.tk.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by shwy on 2017/10/22.
 */
public class MoodPO {
    private Integer id;
    private String title;
    private String pictureUrl;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishTime;
    private Boolean is_show;


    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getIs_show() {
        return is_show;
    }

    public void setIs_show(Boolean is_show) {
        this.is_show = is_show;
    }

}