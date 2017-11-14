package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MusicDAO;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.pojo.po.MusicPO;
import shwy.tk.service.MusicService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */
@Service("musicService")
public class MusciServiceImpl implements MusicService {

    @Autowired
    private MusicDAO musicDAO;

    @Override
    public List<MusicPO> musicPO(int dan) {
        return musicDAO.musicPO(dan);
    }

    @Override
    public List<MusicListPO> listMusicList() {
        return null;
    }

    @Override
    public Long getMusicCount(HashMap<String, Object> param) {
        return musicDAO.getMusicCount(param);
    }


    @Override
    public int deleteMusic(Integer id) {
        return musicDAO.deleteMusic(id);
    }

    @Override
    public int updateMusic(MusicPO musicPO) {
        return musicDAO.updateMusic(musicPO);
    }

    @Override
    public int addMusic(MusicPO musicPO) {
        return musicDAO.addMusic(musicPO);
    }

    @Override
    public List<MusicPO> listMusic(HashMap<String, Object> param) {
        return musicDAO.listMusic(param);
    }

    @Override
    public List<MusicPO> listAllMusic() {
        return musicDAO.listAllMusic();
    }

    @Override
    public MusicPO getMusic(int id) {
        return musicDAO.getMusic(id);
    }
}
