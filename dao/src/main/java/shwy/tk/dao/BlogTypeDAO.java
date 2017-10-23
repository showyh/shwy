package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.BlogTypePO;

import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface BlogTypeDAO {

    List<BlogTypePO> listBlogTypePO();

    BlogTypePO getBlogType(@Param("blogTypeId") Integer blogTypeId);

    int updateBlogType(BlogTypePO blogTypePO);

    int deleteBlogType(@Param("id") Integer id);

    int addBlogType(BlogTypePO blogTypePO);

}
