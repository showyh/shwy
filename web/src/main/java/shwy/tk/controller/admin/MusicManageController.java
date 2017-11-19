package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.pojo.po.MusicPO;
import shwy.tk.service.MusicListService;
import shwy.tk.service.MusicService;
import shwy.tk.utils.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwy on 2017/11/10.
 */
@Controller
@RequestMapping("/admin")
public class MusicManageController {
    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicListService musicListService;

    @RequestMapping("/musicManage")
    public ModelAndView musicManage() {
        ModelAndView mav = new ModelAndView("background/musicManage");
        List<MusicPO> listMusic = musicService.listAllMusic();
        List<MusicListPO> listMusicList=musicListService.listAllMusicList();
        mav.addObject("listMusicList", listMusicList);
        mav.addObject("listMusic",listMusic);
        return mav;
    }
    @RequestMapping(value = "/musicManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<MusicPO> musicManagePage(@PathVariable String page, String pageSize) {
        //获取音乐列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<MusicPO> musicList = musicService.listMusic(param);

        return musicList;

    }


    @RequestMapping("/writeMusic")
    public ModelAndView writeMusic(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writeMusic");
        if (StringUtil.isNotEmpty(id)) {
            MusicPO musicPO = musicService.getMusic(Integer.parseInt(id));
            mav.addObject("music", musicPO);
        }
        List<MusicListPO> listMusicList=musicListService.listAllMusicList();
        mav.addObject("listMusicList",listMusicList);
        return mav;
    }


    @RequestMapping("/addMusic")
    public String addMusic(MusicPO musicPO) throws Exception {
        int result = 0;
        if (musicPO.getId() != null) {
            result = musicService.updateMusic(musicPO);
        } else {
            result = musicService.addMusic(musicPO);
        }
        if (result > 0) {
            return "redirect:/admin/musicManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadMusicImage")
    @ResponseBody
    public String uploadMusicImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/music/musicImage/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String musicImage = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("img", musicImage);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }
    @RequestMapping("/uploadMusic")
    @ResponseBody
    public String uploadMusic(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String musicName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/music/musicName/" + musicName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String Music = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("src", Music);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMusic(@PathVariable Integer id) {
        int result = musicService.deleteMusic(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
