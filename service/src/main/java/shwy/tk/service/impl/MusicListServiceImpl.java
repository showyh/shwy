package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MusicListDAO;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.service.MusicListService;

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
}
