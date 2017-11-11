package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.PhotoPO;
import shwy.tk.service.PhotoService;
import shwy.tk.utils.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwy on 2017/11/10.
 */
@Controller
@RequestMapping("/admin")
public class PhotoManageController {
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/photoManage")
    public ModelAndView photoManage() {
        ModelAndView mav = new ModelAndView("background/photoManage");
        List<PhotoPO> photoList = photoService.listAllPhoto();
        mav.addObject("photoList",photoList);
        return mav;
    }
    @RequestMapping(value = "/photoManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<PhotoPO> photoManagePage(@PathVariable String page, String pageSize) {
        //获取博文列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<PhotoPO> photoList = photoService.listPhoto(param);
        return photoList;

    }


    @RequestMapping("/writePhoto")

    public ModelAndView addPhoto(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writePhoto");
        if (StringUtil.isNotEmpty(id)) {
            PhotoPO photoPO = photoService.getPhoto(Integer.parseInt(id));
            mav.addObject("photo", photoPO);
        }
        return mav;
    }


    @RequestMapping("/addPhoto")
    public String addPhoto(PhotoPO photoPO) throws Exception {
        int result = 0;
        if (photoPO.getId() != null) {
            result = photoService.updatePhoto(photoPO);
        } else {
            result = photoService.addPhoto(photoPO);
        }
        if (result > 0) {
            return "redirect:/admin/photoManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadPhotoImage")
    @ResponseBody
    public String uploadPhotoImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/photo/coverImage/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String coverImage = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("coverImage", coverImage);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePhoto(@PathVariable Integer id) {
        int result = photoService.deletePhoto(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
