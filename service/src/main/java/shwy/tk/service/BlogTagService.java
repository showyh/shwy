package shwy.tk.service;

import shwy.tk.pojo.po.BlogTagPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface BlogTagService {

    List<BlogTagPO> listBlogTag(HashMap<String, Integer> param);

    int updateBlogTag(BlogTagPO blogTagPO);

    int deleteBlogTag(Integer id);

    int addBlogTag(BlogTagPO blogTagPO);

    Long getBlogTagCount();
}
