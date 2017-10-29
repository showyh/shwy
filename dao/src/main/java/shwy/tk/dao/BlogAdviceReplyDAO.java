package shwy.tk.dao;

import shwy.tk.pojo.po.BlogAdviceReplyPO;
import shwy.tk.pojo.vo.BlogAdviceReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
public interface BlogAdviceReplyDAO {

    List<BlogAdviceReplyVO> listBlogAdviceReplyVO(@Param("blogAdviceId") Integer blogAdviceId);

    int addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO);

    int deleteBlogAdviceReply(@Param("blogAdviceId") Integer blogAdviceId);

}
