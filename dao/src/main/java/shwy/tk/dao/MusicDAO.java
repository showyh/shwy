package shwy.tk.dao;

import shwy.tk.pojo.po.MusicPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */
public interface MusicDAO {

    List<MusicPO> musicPO(int dan);

    Long getMusicCount(HashMap<String, Object> param);

    int deleteMusic(Integer id);

    int updateMusic(MusicPO musicPO);

    int addMusic(MusicPO musicPO);

    List<MusicPO> listMusic(HashMap<String, Object> param);

    List<MusicPO> listAllMusic();

    MusicPO getMusic(int id);


}
