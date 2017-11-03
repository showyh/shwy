package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MusicDAO;
import shwy.tk.pojo.po.MusicPO;
import shwy.tk.service.MusicService;

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
}
