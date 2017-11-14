package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MusicListDAO;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.service.MusicListService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/11/2.
 */
@Service("musicListService")
public class MusicListServiceImpl implements MusicListService {
    @Autowired
    private MusicListDAO musicListDAO;

    @Override
    public List<MusicListPO> musicListPO() {
        return musicListDAO.musicListPO();
    }

    @Override
    public int deleteMusicList(Integer id) {
        return musicListDAO.deleteMusicList(id);
    }

    @Override
    public int updateMusicList(MusicListPO musicListPO) {
        return musicListDAO.updateMusicList(musicListPO);
    }

    @Override
    public MusicListPO getMusicList(int id) {
        return musicListDAO.getMusicList(id);
    }

    @Override
    public int addMusicList(MusicListPO musicListPO) {
        return musicListDAO.addMusicList(musicListPO);
    }

    @Override
    public List<MusicListPO> listMusicList(HashMap<String, Object> param) {
        return musicListDAO.listMusicList(param);
    }

    @Override
    public List<MusicListPO> listAllMusicList() {
        return musicListDAO.listAllMusicList();
    }

    @Override
    public Long getMusicListCount(HashMap<String, Object> param) {
        return musicListDAO.getMusicListCount(param);
    }
}
