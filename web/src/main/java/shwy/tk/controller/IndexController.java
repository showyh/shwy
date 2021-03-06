package shwy.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.controller.utils.RequestUtil;
import shwy.tk.pojo.po.VisitorPO;
import shwy.tk.pojo.vo.BlogVO;
import shwy.tk.pojo.vo.CommentVO;
import shwy.tk.service.BlogService;
import shwy.tk.service.CommentService;
import shwy.tk.service.LikeService;
import shwy.tk.service.VisitorService;
import shwy.tk.utils.ConfigStrUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author showy on 2017/10/15.
 * @version 1.0
 */
@Controller
@SessionAttributes(value = {"readNum", "likeCount", "hotBlogList", "newCommentList"})
public class IndexController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView goIndex(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("foreground/index");
        //获取点赞数量
        mav.addObject("likeCount", likeService.getLikeCount());
        //获取游客浏览器、操作系统、IP信息
        String userBrowser = RequestUtil.getUserBrowser(request);
        String userOS = RequestUtil.getUserOS(request);
        String userIP = RequestUtil.getUserIP(request);
        VisitorPO visitorPO = new VisitorPO(userIP, userBrowser, userOS);
        visitorService.addVisitor(visitorPO);

        //获取游客浏览数量
        Long readNum = visitorService.getReadNum();
        mav.addObject("readNum", readNum);

        //获取最新5篇博文
        List<BlogVO> newBlogList = blogService.listNewBlog();
        mav.addObject("newBlogList", newBlogList);

        //获取热门5篇博文
        List<BlogVO> hotBlogList = blogService.listHotBlog();
        mav.addObject("hotBlogList", hotBlogList);

        List<CommentVO> newCommentList = commentService.listNewComment();
        mav.addObject("newCommentList", newCommentList);
        return mav;
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String clickLike(HttpServletRequest request) {
        String ip = RequestUtil.getUserIP(request);
        int resultNum = likeService.addLike(ip);
        if (resultNum > 0) {
            // session.removeAttribute("readNum");
            // session.setAttribute("readNum",visitorService.getReadNum());
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }

    }
}
