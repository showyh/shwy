package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.MusicListPO;
import shwy.tk.service.MusicListService;
import shwy.tk.utils.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwy on 2017/11/10.
 */
@Controller
@RequestMapping("/admin")
public class MusicListManageController {
    @Autowired
    private MusicListService musicListService;

    @RequestMapping("/musicListManage")
    public ModelAndView musicListManage() {
        ModelAndView mav = new ModelAndView("background/musicListManage");
        List<MusicListPO> musicListList = musicListService.listAllMusicList();
        mav.addObject("musicListList",musicListList);
        return mav;
    }
    @RequestMapping(value = "/musicListManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<MusicListPO> musicListManagePage(@PathVariable String page, String pageSize) {
        //获取博文列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<MusicListPO> musicListList = musicListService.listMusicList(param);
        return musicListList;

    }


    @RequestMapping("/writeMusicList")
    public ModelAndView writeMusicList(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writeMusicList");
        if (StringUtil.isNotEmpty(id)) {
            MusicListPO musicListPO = musicListService.getMusicList(Integer.parseInt(id));
            mav.addObject("musicList", musicListPO);
        }
        return mav;
    }


    @RequestMapping("/addMusicList")
    public String addMusicList(MusicListPO musicListPO) throws Exception {
        int result = 0;
        if (musicListPO.getId() != null) {
            result = musicListService.updateMusicList(musicListPO);
        } else {
            result = musicListService.addMusicList(musicListPO);
        }
        if (result > 0) {
            return "redirect:/admin/musicListManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadMusicListImage")
    @ResponseBody
    public String uploadMusicListImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/musicList/img/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String img = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("img", img);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/musicList/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMusicList(@PathVariable Integer id) {
        int result = musicListService.deleteMusicList(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
