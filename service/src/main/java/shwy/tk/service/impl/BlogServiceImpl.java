package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.BlogDAO;
import shwy.tk.dao.CommentDAO;
import shwy.tk.dao.CommentReplyDAO;
import shwy.tk.pojo.po.BlogPO;
import shwy.tk.pojo.po.CommentPO;
import shwy.tk.pojo.vo.BlogCommentVO;
import shwy.tk.pojo.vo.BlogDateArchiveVO;
import shwy.tk.pojo.vo.BlogVO;
import shwy.tk.service.BlogService;
import shwy.tk.service.utils.BlogUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author showy on 2017/10/15.
 * @version 1.0
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private CommentReplyDAO commentReplyDAO;

    @Override
    public List<BlogDateArchiveVO> listBlogDateArchive() {
        return blogDAO.listBlogDateArchiveVO();
    }

    @Override
    public BlogVO getRecommendBlog() {
        BlogVO recommendBlogVO = blogDAO.getRecommendBlogVO();
        BlogUtil.setBlogVO(recommendBlogVO, commentDAO);
        return recommendBlogVO;
    }

    @Override
    public List<BlogVO> listNewBlog() {
        List<BlogVO> blogVOList = blogDAO.listNewBlog();
        for (BlogVO blogVO : blogVOList) {
            BlogUtil.setBlogVO(blogVO, commentDAO);
        }
        return blogVOList;
    }

    @Override
    public List<BlogVO> listHotBlog() {
        List<BlogVO> blogVOList = blogDAO.listHotBlog();
        for (BlogVO blogVO : blogVOList) {
            BlogUtil.setBlogVO(blogVO, commentDAO);
        }
        return blogVOList;
    }

    @Override
    public BlogPO getBlog(Integer id) {
        return blogDAO.getBlog(id);
    }

    @Override
    public int updateBlogReadNum(Integer id) {
        return blogDAO.updateBlogReadNum(id);
    }

    @Override
    public List<BlogVO> listBlog(HashMap<String, Object> param) {
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        for (BlogVO blogVO : blogVOList) {
            BlogUtil.setBlogVO(blogVO, commentDAO);
        }
        return blogVOList;
    }

    @Override
    public Long getBlogCount(HashMap<String, Object> param) {
        return blogDAO.getBlogCount(param);
    }

    @Override
    public List<BlogPO> listBlogPO(HashMap<String, Object> param) {
        return blogDAO.listBlogPO(param);
    }

    @Override
    public int addBlog(BlogPO blogPO) {
        return blogDAO.addBlog(blogPO);
    }

    @Override
    public int updateBlog(BlogPO blogPO) {
        return blogDAO.updateBlog(blogPO);
    }

    @Override
    public int deleteBlog(Integer id) {
        HashMap<String, Integer> param = new HashMap<>();
        param.put("blogId", id);
        List<CommentPO> commentPOList = commentDAO.listCommentPO(param);
        for (CommentPO commentPO : commentPOList) {
            commentReplyDAO.deleteCommentReply(commentPO.getId());
        }
        commentDAO.deleteComment(param);
        return blogDAO.deleteBlog(id);
    }

    @Override
    public BlogCommentVO getBlogCommentVO(Integer id) {
        return blogDAO.getBlogCommentVO(id);
    }


}
