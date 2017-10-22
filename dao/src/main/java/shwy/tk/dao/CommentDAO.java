package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.vo.CommentVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/18.
 */
public interface CommentDAO {

    Long getCommentCount(@Param("blogId") Integer blogId);

    List<CommentVO> listNewCommentVO();

    List<CommentPO> listCommentPO(HashMap<String, Integer> param);

    int addComment(CommentPO commentPO);

    int deleteComment(HashMap<String, Integer> param);


}
