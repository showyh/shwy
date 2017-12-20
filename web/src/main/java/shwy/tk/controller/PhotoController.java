package shwy.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.controller.utils.PageUtil;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.PhotoPO;
import shwy.tk.service.PhotoService;
import shwy.tk.utils.ConfigStrUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/17.
 */
@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;


    //获取相册列表
    @RequestMapping(value = "/photo/list", method = RequestMethod.GET)
    public String photoList() {
        return "redirect:/photo/list/1";
    }

    @RequestMapping(value = "/photo/list/{page}", method = RequestMethod.GET)
    public ModelAndView photoList(@PathVariable String page) {
        ModelAndView mav = new ModelAndView("foreground/photo");
        HashMap<String, Object> param = new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean = new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.PhotoListPageSize);
        param.put("start", pageBean.getStart());
        param.put("pageSize", pageBean.getPageSize());
        //拼装筛选参数
        List<PhotoPO> photoList = photoService.listPhoto(param);

        //获取总记录数
        Long count = photoService.getPhotoCount(param);
        //拼装分页代码
        String targetUrl = "/photo/list";
        String pageNation = PageUtil.getPageNation(count, targetUrl, pageBean.getPage(), pageBean.getPageSize());

        mav.addObject("photoList", photoList);
        mav.addObject("pageNation", pageNation);
        return mav;
    }

}
