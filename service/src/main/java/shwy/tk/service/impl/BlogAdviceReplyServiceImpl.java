package shwy.tk.service.impl;

import shwy.tk.dao.BlogAdviceReplyDAO;
import shwy.tk.pojo.po.BlogAdviceReplyPO;
import shwy.tk.service.BlogAdviceReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shwy on 2017/10/29.
 */
@Service("blogAdviceReplyService")
public class BlogAdviceReplyServiceImpl implements BlogAdviceReplyService {

    @Autowired
    private BlogAdviceReplyDAO blogAdviceReplyDAO;

    @Override
    public int addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO) {
        return blogAdviceReplyDAO.addBlogAdviceReply(blogAdviceReplyPO);
    }
}
