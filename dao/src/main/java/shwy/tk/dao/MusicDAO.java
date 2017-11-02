package shwy.tk.dao;

import shwy.tk.pojo.po.MusicPO;

import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */
public interface MusicDAO {
    List<MusicPO>  musicPO(int dan);
}
