package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.BlogTagPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface BlogTagDAO {

    List<BlogTagPO> listBlogTagPO(HashMap<String, Integer> param);

    BlogTagPO getBlogTag(@Param("blogTagId") Integer blogTagId);

    int updateBlogTag(BlogTagPO blogTagPO);

    int deleteBlogTag(@Param("id") Integer id);

    int addBlogTag(BlogTagPO blogTagPO);

    Long getBlogTagCount();

}
