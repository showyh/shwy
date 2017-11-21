package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.MoodPO;
import shwy.tk.pojo.vo.TimeLineVO;
import shwy.tk.service.TimeLineService;
import shwy.tk.utils.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwy on 2017/10/17.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"moodNum"})
public class MoodManageController {

    @Autowired
    private TimeLineService timeLineService;

    @RequestMapping("/moodManage")
    public ModelAndView moodManage() {
        ModelAndView mav = new ModelAndView("background/moodManage");
        //获取下拉框
        Long moodNum = timeLineService.getMoodCount();
        List<MoodPO> moodList = timeLineService.listMoodPO(new HashMap<>());
        List<TimeLineVO> timeLineList = timeLineService.listTimeLine();

        mav.addObject("moodNum", moodNum);
        mav.addObject("moodList", moodList);
        mav.addObject("timeLineList", timeLineList);
        return mav;
    }
    @RequestMapping(value = "/moodManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<MoodPO> moodManagePage(@PathVariable String page, String pageSize) {
        //获取博文列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Object> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<MoodPO> moodList = timeLineService.listMoodPO(param);
        return moodList;
    }


    @RequestMapping("/writeMood")
    /* required=false表示不传的话，会给参数赋值为null，@RequestParam注解的参数是int基本类型，
    但是required=false，这时如果不传参数值会报错，因为不传值，会赋值为null给int，解决方法：
   “Integer”代替“int”required=true就是必须要有 value="aa"表示传入参数指定为aa，
   如果前端不传aa参数名，会报错*/
    public ModelAndView writeMood(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("background/writeMood");
        if (StringUtil.isNotEmpty(id)) {
            MoodPO moodPO = timeLineService.getMood(Integer.parseInt(id));
            mav.addObject("mood", moodPO);
        }
        //获取下拉框
        List<TimeLineVO> timeLineList = timeLineService.listTimeLine();
        mav.addObject("timeLineList", timeLineList);
        return mav;
    }


    @RequestMapping("/addMood")
    public String addMood(MoodPO moodPO) throws Exception {
        moodPO.setPublishTime(new Date());
        int result = 0;
        if (moodPO.getId() != null) {
            result = timeLineService.updateMood(moodPO);
        } else {
            result = timeLineService.addMood(moodPO);
        }
        if (result > 0) {
            return "redirect:/admin/moodManage";
        } else {
            return null;
        }
    }

    @RequestMapping("/uploadMooodImages")
    @ResponseBody
    public String uploadBlogImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String imageName = DateUtil.getCurrentTimeStr();
        String filePath = "shwy/moodImages/" + imageName + "." + file.getOriginalFilename().split("\\.")[1];
        Boolean uploadResult = QiNiuUploadUtil.upload(file.getInputStream(), filePath);
        Map<String, String> jsonMap = new HashMap<>();
        if (uploadResult) {
            String moodImages = ConfigStrUtil.QINIU_URL + filePath;
            jsonMap.put("pictureUrl", moodImages);
            jsonMap.put("success", "true");
            return JacksonUtil.toJSon(jsonMap);
        } else {
            jsonMap.put("success", "false");
            return JacksonUtil.toJSon(jsonMap);
        }
    }

    @RequestMapping(value = "/mood/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMood(@PathVariable Integer id) {
        int result = timeLineService.deleteMood(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }

}
