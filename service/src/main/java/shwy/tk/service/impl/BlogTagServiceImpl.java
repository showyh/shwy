package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.BlogDAO;
import shwy.tk.dao.BlogTagDAO;
import shwy.tk.pojo.po.BlogTagPO;
import shwy.tk.pojo.vo.BlogVO;
import shwy.tk.service.BlogTagService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("blogTagService")
public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagDAO blogTagDAO;

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<BlogTagPO> listBlogTag(HashMap<String, Integer> param) {
        return blogTagDAO.listBlogTagPO(param);
    }

    @Override
    public int updateBlogTag(BlogTagPO blogTagPO) {
        return blogTagDAO.updateBlogTag(blogTagPO);
    }

    @Override
    public int deleteBlogTag(Integer id) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("blogTagId", id);
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        if (blogVOList.size() > 0) {
            return 0;
        }
        return blogTagDAO.deleteBlogTag(id);
    }

    @Override
    public int addBlogTag(BlogTagPO blogTagPO) {
        return blogTagDAO.addBlogTag(blogTagPO);
    }

    @Override
    public Long getBlogTagCount() {
        return blogTagDAO.getBlogTagCount();
    }
}
