package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.po.LoginHistoryPO;
import shwy.tk.service.*;

import java.util.HashMap;

/**
 * Created by shwy on 2017/10/20.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"blogNum","photoNum","imageNum","commentNum","musicNum","musicListNum"})
public class MainController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogAdviceService blogAdviceService;

    @Autowired
    private BlogService blogService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicListService musicListService;

    @RequestMapping("/main")
    public ModelAndView goMain() {
        ModelAndView mav = new ModelAndView("background/main");
        //获取上一条登录信息
        LoginHistoryPO loginHistory = adminService.getLoginHistory();
        //获取今日访客数量
        Long todayReadNum = visitorService.getTodayReadNum();
        //获取今日点赞量
        Long todayLike = likeService.getTodayLike();
        //访问总数
        Long readNum = visitorService.getReadNum();
        //点赞总数
        Long likeNum = likeService.getLikeCount();
        //获取评论总数
        Long commentNum = commentService.getCommentCount();
        //获取未回复留言总数
        Long notReplyNum = blogAdviceService.getNotReplyCount();
        //获取文章总数
        Long blogNum = blogService.getBlogCount(new HashMap<>());
        //获取相册总数
        Long photoNum = photoService.getPhotoCount(new HashMap<>());
        //获取照片总数
        Long imageNum = imagesService.getImagesCount(new HashMap<>());
        //获取照片总数
        Long musicNum = musicService.getMusicCount(new HashMap<>());
        //获取照片总数
        Long musicListNum = musicListService.getMusicListCount(new HashMap<>());

        mav.addObject("loginHistory", loginHistory);
        mav.addObject("todayReadNum", todayReadNum);
        mav.addObject("todayLike", todayLike);
        mav.addObject("readNum", readNum);
        mav.addObject("likeNum", likeNum);
        mav.addObject("commentNum", commentNum);
        mav.addObject("notReplyNum", notReplyNum);
        mav.addObject("blogNum", blogNum);
        mav.addObject("photoNum", photoNum);
        mav.addObject("imageNum", imageNum);
        mav.addObject("musicNum", musicNum);
        mav.addObject("musicListNum", musicListNum);

        return mav;
    }
}
