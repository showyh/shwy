package shwy.tk.pojo.po;

/**
 * Created by shwy on 2017/10/31.
 */
public class MusicPO {
    private Integer id;
    private String name;
    private String singer;
    private String src;
    private String musicImg;
    private String time;
    private String lrc;
    private Integer dan;
    private MusicListPO musicListPO;

    public MusicListPO getMusicListPO() {
        return musicListPO;
    }

    public void setMusicListPO(MusicListPO musicListPO) {
        this.musicListPO = musicListPO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMusicImg() {
        return musicImg;
    }

    public void setMusicImg(String musicImg) {
        this.musicImg = musicImg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public Integer getDan() {
        return dan;
    }

    public void setDan(Integer dan) {
        this.dan = dan;
    }

}
