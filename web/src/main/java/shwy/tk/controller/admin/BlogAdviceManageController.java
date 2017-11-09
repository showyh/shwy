package shwy.tk.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import shwy.tk.controller.utils.RequestUtil;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.BlogAdvicePO;
import shwy.tk.pojo.po.BlogAdviceReplyPO;
import shwy.tk.service.BlogAdviceReplyService;
import shwy.tk.service.BlogAdviceService;
import shwy.tk.utils.ConfigStrUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/11/8.
 */
@Controller
@RequestMapping("/admin")
public class BlogAdviceManageController {
    @Autowired
    private BlogAdviceService blogAdviceService;
    @Autowired
    private BlogAdviceReplyService blogAdviceReplyService;

    @RequestMapping("/blogAdviceManage")
    public String BlogAdviceManage(HttpSession session) {
        Long blogAdviceNum = blogAdviceService.getBlogAdviceCount();
        session.setAttribute("blogAdviceNum", blogAdviceNum);
        return "/background/blogAdviceManage";
    }

    @RequestMapping("blogAdviceManage/list/{page}")
    @ResponseBody
    public List<BlogAdvicePO> BlogAdviceManagePage(@PathVariable String page, String pageSize) {
        //获取评论列表
        PageBeanBO pageBeanBO = new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String, Integer> param = new HashMap<>();
        param.put("start", pageBeanBO.getStart());
        param.put("pageSize", pageBeanBO.getPageSize());

        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);
        return blogAdviceList;

    }

    @RequestMapping(value = "/blogAdvice/reply", method = RequestMethod.POST)
    public String addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO, HttpServletRequest request) {
        String userIP = RequestUtil.getUserIP(request);
        blogAdviceReplyPO.setUserIP(userIP);
        blogAdviceReplyPO.setPublishTime(new Date());
        blogAdviceReplyPO.setRole(true);
        int result = blogAdviceReplyService.addBlogAdviceReply(blogAdviceReplyPO);
        if (result > 0) {
            return "redirect:/admin/blogAdviceManage";
        } else {
            return null;
        }

    }
        //删除评论
    @RequestMapping(value = "/blogAdvice/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteComment(@PathVariable Integer id) {
        int result = blogAdviceService.deleteBlogAdvice(id);
        if (result > 0) {
            return ConfigStrUtil.SUCCESS;
        } else {
            return ConfigStrUtil.ERROR;
        }
    }
}
