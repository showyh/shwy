package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.BlogPO;
import shwy.tk.pojo.vo.BlogCommentVO;
import shwy.tk.pojo.vo.BlogDateArchiveVO;
import shwy.tk.pojo.vo.BlogVO;

import java.util.HashMap;
import java.util.List;

/**
 * @author showy on 2017/10/15.
 * @version 1.0
 */
public interface BlogDAO {

    List<BlogDateArchiveVO> listBlogDateArchiveVO();

    BlogVO getRecommendBlogVO();

    List<BlogVO> listNewBlog();

    List<BlogVO> listHotBlog();

    BlogPO getBlog(Integer id);

    int updateBlogReadNum(Integer id);

    List<BlogVO> listBlog(HashMap<String, Object> param);

    Long getBlogCount(HashMap<String, Object> param);

    List<BlogPO> listBlogPO(HashMap<String, Object> param);

    int addBlog(BlogPO blogPO);

    int updateBlog(BlogPO blogPO);

    int deleteBlog(Integer id);

    BlogCommentVO getBlogCommentVO(@Param("id") Integer id);

}
