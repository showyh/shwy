package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.ImagesPO;
import shwy.tk.pojo.po.PhotoPO;
import shwy.tk.service.ImagesService;
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
public class ImageManageController {
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/imageManage")
    public ModelAndView imageManage() {
        ModelAndView mav = new ModelAndView("background/imageManage");
        List<PhotoPO> photoList = photoService.listAllPhoto();
        mav.addObject("photoList",photoList);
        return mav;
    }
    @RequestMapping(value = "/imageManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<ImagesPO> imageManagePage(@PathVariable String page, String pageSize) {
        //获取照片列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<ImagesPO> imageList = imagesService.listImagesPO(param);
        return imageList;

    }


    @RequestMapping("/writeImage")
    public ModelAndView addImage(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writeImage");
        if (StringUtil.isNotEmpty(id)) {
            ImagesPO imagesPO = imagesService.getImage(Integer.parseInt(id));
             mav.addObject("image", imagesPO);

        }
        List<PhotoPO> listPhoto=photoService.listPhoto(new HashMap<>());
        mav.addObject("listPhoto", listPhoto);
        return mav;
    }


    @RequestMapping("/addImage")
    public String addImage(ImagesPO imagesPO) throws Exception {
        int result = 0;
        if (imagesPO.getId() != null) {
            result = imagesService.updateImage(imagesPO);
        } else {
            result = imagesService.addImage(imagesPO);
        }
        if (result > 0) {
            return "redirect:/admin/imageManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadImages")
    @ResponseBody
    public String uploadImages(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/image/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String imageUrl = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("imageUrl", imageUrl);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteImage(@PathVariable Integer id) {
        int result = imagesService.deleteImage(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
