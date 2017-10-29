package shwy.tk.service.impl;

import shwy.tk.dao.BlogAdviceDAO;
import shwy.tk.dao.BlogAdviceReplyDAO;
import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.BlogAdvicePO;
import shwy.tk.service.BlogAdviceService;
import shwy.tk.service.utils.BlogAdviceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
@Service("blogAdviceService")
public class BlogAdviceServiceImpl implements BlogAdviceService {

    @Autowired
    private BlogAdviceDAO blogAdviceDAO;

    @Autowired
    private BlogAdviceReplyDAO blogAdviceReplyDAO;

    @Override
    public List<BlogAdvicePO> listBlogAdvice(PageBeanBO pageBeanBO) {
        List<BlogAdvicePO> blogAdviceList = blogAdviceDAO.listBlogAdvicePO(pageBeanBO);
        BlogAdviceUtil.setBlogAdvice(blogAdviceList,blogAdviceReplyDAO);
        return blogAdviceList;
    }

    @Override
    public Long getBlogAdviceCount() {
        return blogAdviceDAO.getBlogAdviceCount();
    }

    @Override
    public int addBlogAdvice(BlogAdvicePO blogAdvicePO) {
        return blogAdviceDAO.addBlogAdvice(blogAdvicePO);
    }

    @Override
    public Long getNotReplyCount() {
        return blogAdviceDAO.getNotReplyCount();
    }

    @Override
    public int deleteBlogAdvice(Integer id) {
        blogAdviceReplyDAO.deleteBlogAdviceReply(id);
        return blogAdviceDAO.deleteBlogAdvice(id);
    }
}
