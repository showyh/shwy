package shwy.tk.pojo.po;

/**
 * Created by shwy on 2017/11/1.
 */
public class MusicListPO {
    private Integer id;
    private boolean basic;
    private String musicListName;
    private String img;
    private String singer;

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isBasic() {
        return basic;
    }

    public void setBasic(boolean basic) {
        this.basic = basic;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
