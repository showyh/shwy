package shwy.tk.service;

import shwy.tk.pojo.po.MusicPO;

import java.util.List;

/**
 * Created by shwy on 2017/10/31.
 */

public interface MusicService {
     List<MusicPO> musicPO(int dan);
}