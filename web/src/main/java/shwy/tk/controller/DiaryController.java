package shwy.tk.controller;

import shwy.tk.pojo.vo.TimeLineVO;
import shwy.tk.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shwy on 2017/10/17.
 */
@Controller
public class DiaryController {

    @Autowired
    private TimeLineService timeLineService;

    @RequestMapping("/diary")
    public ModelAndView diary() {
        ModelAndView mav = new ModelAndView("foreground/diary");
        List<TimeLineVO> timeLineList = timeLineService.listTimeLine();
        mav.addObject("timeLineList", timeLineList);
        return mav;
    }
}
