package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.BlogDAO;
import shwy.tk.dao.BlogTypeDAO;
import shwy.tk.pojo.po.BlogTypePO;
import shwy.tk.pojo.vo.BlogVO;
import shwy.tk.service.BlogTypeService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeDAO blogTypeDAO;

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<BlogTypePO> listBlogType() {
        return blogTypeDAO.listBlogTypePO();
    }

    @Override
    public int updateBlogType(BlogTypePO blogTypePO) {
        return blogTypeDAO.updateBlogType(blogTypePO);
    }

    @Override
    public int deleteBlogType(Integer id) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("blogTypeId", id.toString());
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        if (blogVOList.size() > 0) {
            for (BlogVO blogVO : blogVOList) {
                blogDAO.deleteBlog(blogVO.getId());
            }
        }
        return blogTypeDAO.deleteBlogType(id);
    }

    @Override
    public int addBlogType(BlogTypePO blogTypePO) {
        return blogTypeDAO.addBlogType(blogTypePO);
    }
}
