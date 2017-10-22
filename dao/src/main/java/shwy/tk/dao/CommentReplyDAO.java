package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.CommentReplyPO;
import shwy.tk.pojo.vo.CommentReplyVO;

import java.util.List;

/**
 * Created by shwy on 2017/10/18.
 */
public interface CommentReplyDAO {

    List<CommentReplyVO> listCommentReply(@Param("commentId") Integer commentId);

    int addCommentReply(CommentReplyPO commentReplyPO);

    int deleteCommentReply(@Param("commentId") Integer commentId);
}
