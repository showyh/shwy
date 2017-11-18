package shwy.tk.service;

import shwy.tk.pojo.po.MusicPO;
import shwy.tk.pojo.vo.MusicVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */

public interface MusicService {

    List<MusicVO> musicVO(int dan);

    Long getMusicCount(HashMap<String, Object> param);

    int deleteMusic(Integer id);

    int updateMusic(MusicPO musicPO);

    int addMusic(MusicPO musicPO);

    List<MusicPO> listMusic(HashMap<String, Object> param);

    List<MusicPO> listAllMusic();

    MusicPO getMusic(int id);


}