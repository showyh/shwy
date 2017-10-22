package shwy.tk.service.utils;

import shwy.tk.dao.CommentReplyDAO;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.vo.CommentReplyVO;

import java.util.List;

/**
 * Created by shwy on 2017/10/12.
 */
public class CommentUtil {

    public static void setCommentList(List<CommentPO> commentPOList, CommentReplyDAO commentReplyDAO) {
        for (CommentPO commentPO : commentPOList) {
            List<CommentReplyVO> commentReplyVOList = commentReplyDAO.listCommentReply(commentPO.getId());
            commentPO.setCommentReplyVOList(commentReplyVOList);
        }
    }
}
