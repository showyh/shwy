package shwy.tk.dao;

import shwy.tk.pojo.po.MusicListPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/11/2.
 */
public interface MusicListDAO {
    List<MusicListPO> musicListPO();

    MusicListPO getMusicList(int id);

    int addMusicList(MusicListPO musicListPO);

    int updateMusicList(MusicListPO musicListPO);

    int deleteMusicList(Integer id);

    Long getMusicListCount(HashMap<String, Object> param);

    List<MusicListPO> listAllMusicList();

    List<MusicListPO> listMusicList(HashMap<String, Object> param);


}
