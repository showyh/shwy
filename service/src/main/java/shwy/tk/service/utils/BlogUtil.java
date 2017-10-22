package shwy.tk.service.utils;

import shwy.tk.dao.CommentDAO;
import shwy.tk.pojo.vo.BlogVO;
/**
 * Created by shwy on 2017/10/12.
 */
public class BlogUtil {

    public static void setBlogVO(BlogVO blogVO, CommentDAO commentDAO) {
        blogVO.setCommentCount(commentDAO.getCommentCount(blogVO.getId()));
    }
}
