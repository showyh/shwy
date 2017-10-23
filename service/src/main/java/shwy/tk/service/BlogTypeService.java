package shwy.tk.service;

import shwy.tk.pojo.po.BlogTypePO;

import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface BlogTypeService {

    List<BlogTypePO> listBlogType();

    int updateBlogType(BlogTypePO blogTypePO);

    int deleteBlogType(Integer id);

    int addBlogType(BlogTypePO blogTypePO);
}
