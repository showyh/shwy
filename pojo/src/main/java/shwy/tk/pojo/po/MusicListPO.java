package shwy.tk.pojo.po;

/**
 * Created by shwy on 2017/11/1.
 */
public class MusicListPO {
    private Integer id;
    private boolean basic;



    private String music_list_name;
    private String img;
    private String singer;

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

    public String getMusic_list_name() {
        return music_list_name;
    }

    public void setMusic_list_name(String music_list_name) {
        this.music_list_name = music_list_name;
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
