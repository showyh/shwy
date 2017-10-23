package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.CommentDAO;
import shwy.tk.dao.CommentReplyDAO;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.vo.CommentVO;
import shwy.tk.service.CommentService;
import shwy.tk.service.utils.CommentUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private CommentReplyDAO commentReplyDAO;

    @Override
    public List<CommentVO> listNewComment() {
        return commentDAO.listNewCommentVO();
    }

    @Override
    public List<CommentPO> listComment(HashMap<String, Integer> param) {
        List<CommentPO> commentPOList = commentDAO.listCommentPO(param);
        CommentUtil.setCommentList(commentPOList, commentReplyDAO);
        return commentPOList;
    }

    @Override
    public int addComment(CommentPO commentPO) {
        return commentDAO.addComment(commentPO);
    }

    @Override
    public Long getCommentCount() {
        return commentDAO.getCommentCount(null);
    }

    @Override
    public int deleteComment(Integer id) {
        commentReplyDAO.deleteCommentReply(id);
        HashMap<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return commentDAO.deleteComment(param);
    }
}
