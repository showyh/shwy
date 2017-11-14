package shwy.tk.service;

import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.pojo.po.MusicPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */

public interface MusicService {

    List<MusicPO> musicPO(int dan);

    List<MusicListPO> listMusicList();

    Long getMusicCount(HashMap<String, Object> param);

    int deleteMusic(Integer id);

    int updateMusic(MusicPO musicPO);

    int addMusic(MusicPO musicPO);

    List<MusicPO> listMusic(HashMap<String, Object> param);

    List<MusicPO> listAllMusic();

    MusicPO getMusic(int id);


}