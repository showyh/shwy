package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.BlogPO;
import shwy.tk.pojo.po.BlogTagPO;
import shwy.tk.pojo.po.BlogTypePO;
import shwy.tk.service.BlogService;
import shwy.tk.service.BlogTagService;
import shwy.tk.service.BlogTypeService;
import shwy.tk.utils.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwy on 2017/10/17.
 */
@Controller
@RequestMapping("/admin")
public class BlogManageController {

    @Autowired
    private BlogTagService blogTagService;

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogManage")
    public ModelAndView blogManage() {
        ModelAndView mav = new ModelAndView("background/blogManage");
        //获取下拉框
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag(new HashMap<>());
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();

        mav.addObject("blogTagList", blogTagList);
        mav.addObject("blogTypeList", blogTypeList);
        return mav;
    }
    @RequestMapping(value = "/blogManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogPO> blogManagePage(@PathVariable String page, String pageSize) {
        //获取博文列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<BlogPO> blogList = blogService.listBlogPO(param);
        return blogList;
    }


    @RequestMapping("/writeBlog")
    /* required=false表示不传的话，会给参数赋值为null，@RequestParam注解的参数是int基本类型，
    但是required=false，这时如果不传参数值会报错，因为不传值，会赋值为null给int，解决方法：
   “Integer”代替“int”required=true就是必须要有 value="aa"表示传入参数指定为aa，
   如果前端不传aa参数名，会报错*/
    public ModelAndView writeBlog(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writeBlog");
        if (StringUtil.isNotEmpty(id)) {
            BlogPO blogPO = blogService.getBlog(Integer.parseInt(id));
            mav.addObject("blog", blogPO);
        }
        //获取下拉框
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag(new HashMap<>());
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();
        mav.addObject("blogTagList", blogTagList);
        mav.addObject("blogTypeList", blogTypeList);
        return mav;
    }


    @RequestMapping("/addBlog")
    public String addBlog(BlogPO blogPO) throws Exception {
        int result = 0;
        if (blogPO.getId() != null) {
            result = blogService.updateBlog(blogPO);
        } else {
            result = blogService.addBlog(blogPO);
        }
        if (result > 0) {
            return "redirect:/admin/blogManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/blog/coverImage/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String coverImageName = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("coverImageName", coverImageName);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBlog(@PathVariable Integer id) {
        int result = blogService.deleteBlog(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
