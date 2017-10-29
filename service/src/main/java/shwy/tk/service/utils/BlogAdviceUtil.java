package shwy.tk.service.utils;

import shwy.tk.dao.BlogAdviceReplyDAO;
import shwy.tk.pojo.po.BlogAdvicePO;
import shwy.tk.pojo.vo.BlogAdviceReplyVO;

import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
public class BlogAdviceUtil {

    public static void setBlogAdvice(List<BlogAdvicePO> blogAdviceList, BlogAdviceReplyDAO blogAdviceReplyDAO){
        for(BlogAdvicePO blogAdvicePO:blogAdviceList){
            List<BlogAdviceReplyVO> blogAdviceReplyVOList = blogAdviceReplyDAO.listBlogAdviceReplyVO(blogAdvicePO.getId());
            blogAdvicePO.setBlogAdviceReplyVOList(blogAdviceReplyVOList);
        }

    }
}
