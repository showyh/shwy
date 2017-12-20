package shwy.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.controller.utils.PageUtil;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.vo.ImagesVO;
import shwy.tk.service.ImagesService;
import shwy.tk.utils.ConfigStrUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/27.
 */
@Controller
public class ImagesController {


    @Autowired
    private ImagesService imagesService;


    //获取相片列表
    @RequestMapping(value = "/images/{photoId}", method = RequestMethod.GET)
    public String imagesList(@PathVariable Integer photoId) {
        return "redirect:/images/" + photoId + "/list/1";
    }
    @RequestMapping(value = "/images/{photoId}/list/{page}", method = RequestMethod.GET)
    public ModelAndView imagesList(@PathVariable Integer photoId,@PathVariable String page) {
        ModelAndView mav = new ModelAndView("foreground/images");
        HashMap<String, Object> param = new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean = new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.ImageListPageSize);
        param.put("start", pageBean.getStart());
        param.put("pageSize", pageBean.getPageSize());
        //拼装筛选参数
        param.put("photoId", photoId);
        List<ImagesVO> imagesList = imagesService.listImages(param);

        //获取总记录数
        Long count = imagesService.getImagesCount(param);
        //拼装分页代码
        String targetUrl = "/images/" + photoId + "/list";
        String pageNation = PageUtil.getPageNation(count, targetUrl, pageBean.getPage(), pageBean.getPageSize());

        mav.addObject("imagesList", imagesList);
        mav.addObject("pageNation", pageNation);
        return mav;

    }
}
