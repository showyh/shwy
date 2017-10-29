package shwy.tk.dao;

import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.BlogAdvicePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
public interface BlogAdviceDAO {

    List<BlogAdvicePO> listBlogAdvicePO(PageBeanBO pageBeanBO);

    Long getBlogAdviceCount();

    int addBlogAdvice(BlogAdvicePO blogAdvicePO);

    Long getNotReplyCount();

    int deleteBlogAdvice(@Param("id") Integer id);


}
