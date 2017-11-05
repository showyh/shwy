package shwy.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.pojo.po.MusicPO;
import shwy.tk.service.MusicListService;
import shwy.tk.service.MusicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwy on 2017/11/2.
 */
@RestController
public class PlayerController {
    @Autowired
    MusicListService musicListService;
    @Autowired
         MusicService musicService;

    @RequestMapping(value = "/music" ,method= RequestMethod.GET)
    public  List<Object> PlayerPO() {
          List<Object> listPlayerPO = new ArrayList<>();
          List<MusicListPO> musicListPO=musicListService.musicListPO();

          listPlayerPO.add(musicListPO);
          for(int i=0;i<musicListPO.size();i++){
              MusicListPO musicList=musicListPO.get(i);
              int dan=musicList.getId();
              List<MusicPO> musicPO=musicService.musicPO(dan);
              listPlayerPO.add(musicPO);
          }
            return listPlayerPO;
    }
}
