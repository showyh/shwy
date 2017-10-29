package shwy.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shwy.tk.pojo.po.BlogPO;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.service.BlogService;
import shwy.tk.service.CommentService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;



    @RequestMapping(value="/blog/{id}",method = RequestMethod.GET)
    public ModelAndView blogPage(@PathVariable Integer id){
        ModelAndView modelAndView=new ModelAndView("foreground/blog");
        //获取Blog
        BlogPO blog=blogService.getBlog(id);
        if(blog==null){
            modelAndView.setViewName("redirect:/errorPage/404.html");
            return modelAndView;
        }
        //获取该Blog下的评论
        HashMap<String,Integer> param=new HashMap<>();
        param.put("blogId",blog.getId());
        List<CommentPO> commentList=commentService.listComment(param);
        modelAndView.addObject("commentList",commentList);
        //更新阅读数量
        blogService.updateBlogReadNum(id);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

}
