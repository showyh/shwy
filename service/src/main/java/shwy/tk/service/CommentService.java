package shwy.tk.service;

import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.vo.CommentVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/4/17.
 */
public interface CommentService {

    List<CommentVO> listNewComment();

    List<CommentPO> listComment(HashMap<String, Integer> param);

    int addComment(CommentPO commentPO);

    Long getCommentCount();

    int deleteComment(Integer id);
}
