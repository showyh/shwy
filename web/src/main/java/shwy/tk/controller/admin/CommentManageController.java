package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.controller.utils.RequestUtil;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.po.CommentReplyPO;
import shwy.tk.service.BlogService;
import shwy.tk.service.CommentReplyService;
import shwy.tk.service.CommentService;
import shwy.tk.utils.ConfigStrUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/17.
 */
@Controller
@RequestMapping("/admin")
public class CommentManageController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentReplyService commentReplyService;


    @RequestMapping("/commentManage")
    public ModelAndView commentManage() {
        ModelAndView mav = new ModelAndView("background/commentManage");
        return mav;
    }

    @RequestMapping(value = "/commentManage/list/{page}", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentPO> commentManagePage(@PathVariable String page, String pageSize) {
        //获取评论列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Integer> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<CommentPO> commentList = commentService.listComment(param);
        for (CommentPO commentPO : commentList) {
            commentPO.setBlogCommentVO(blogService.getBlogCommentVO(commentPO.getBlogId()));
        }
        return commentList;
    }

    @RequestMapping(value = "/comment/reply", method = RequestMethod.POST)
    public String addCommentReply(CommentReplyPO commentReplyPO, HttpServletRequest request) {
        //获取留言IP
        String userIP = RequestUtil.getUserIP(request);
        commentReplyPO.setUserIP(userIP);
        //设置时间
        commentReplyPO.setPublishTime(new Date());
        //设置角色
        commentReplyPO.setRole(true);
        int result = commentReplyService.addCommentReply(commentReplyPO);
        if (result > 0) {
            return "redirect:/admin/commentManage";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteComment(@PathVariable Integer id) {
        int result = commentService.deleteComment(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }


}
