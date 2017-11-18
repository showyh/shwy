package shwy.tk.service;

import shwy.tk.pojo.po.MusicListPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/11/2.
 */
public interface MusicListService {
    List<MusicListPO> musicListPO();


    MusicListPO getMusicList(int id);

    int addMusicList(MusicListPO musicListPO);

    int deleteMusicList(Integer id);

    int updateMusicList(MusicListPO musicListPO);

    List<MusicListPO> listMusicList(HashMap<String, Object> param);

    List<MusicListPO> listAllMusicList();

    Long getMusicListCount(HashMap<String, Object> param);
}
