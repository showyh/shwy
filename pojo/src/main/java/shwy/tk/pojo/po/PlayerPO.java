package shwy.tk.pojo.po;

import java.util.List;

/**
 * Created by shwy on 2017/11/1.
 */
public class PlayerPO {

    List<MusicListPO> musicListPO;
    List<MusicPO> musicPO;
    public List<MusicListPO> getMusicListPO() {
        return musicListPO;
    }

    public void setMusicListPO(List<MusicListPO> musicListPO) {
        this.musicListPO = musicListPO;
    }

    public List<MusicPO> getMusicPO() {
        return musicPO;
    }

    public void setMusicPO(List<MusicPO> musicPO) {
        this.musicPO = musicPO;
    }
}
