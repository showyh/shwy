package shwy.tk.service;

import shwy.tk.pojo.po.BlogPO;
import shwy.tk.pojo.vo.BlogCommentVO;
import shwy.tk.pojo.vo.BlogDateArchiveVO;
import shwy.tk.pojo.vo.BlogVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/20.
 */
public interface BlogService {

    List<BlogDateArchiveVO> listBlogDateArchive();

    BlogVO getRecommendBlog();

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

    BlogCommentVO getBlogCommentVO(Integer id);


}
