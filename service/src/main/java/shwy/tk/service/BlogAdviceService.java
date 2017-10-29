package shwy.tk.service;

import shwy.tk.pojo.bo.PageBeanBO;
import shwy.tk.pojo.po.BlogAdvicePO;

import java.util.List;

/**
 * Created by shwy on 2017/10/29.
 */
public interface BlogAdviceService {

    List<BlogAdvicePO> listBlogAdvice(PageBeanBO pageBeanBO);

    Long getBlogAdviceCount();

    int addBlogAdvice(BlogAdvicePO blogAdvicePO);

    Long getNotReplyCount();

    int deleteBlogAdvice(Integer id);
}
