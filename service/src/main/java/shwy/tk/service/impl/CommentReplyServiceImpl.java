package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.CommentReplyDAO;
import shwy.tk.pojo.po.CommentReplyPO;
import shwy.tk.service.CommentReplyService;

/**
 * Created by shwy on 2017/10/20.
 */
@Service("commentReplyService")
public class CommentReplyServiceImpl implements CommentReplyService {

    @Autowired
    private CommentReplyDAO commentReplyDAO;

    @Override
    public int addCommentReply(CommentReplyPO commentReplyPO) {
        return commentReplyDAO.addCommentReply(commentReplyPO);
    }
}
