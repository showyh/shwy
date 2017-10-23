package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.LinkDAO;
import shwy.tk.pojo.po.LinkPO;
import shwy.tk.service.LinkService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDAO linkDAO;


    @Override
    public List<LinkPO> listLink(HashMap<String, Integer> param) {
        return linkDAO.listLinkPO(param);
    }

    @Override
    public int updateLink(LinkPO linkPO) {
        return linkDAO.updateLink(linkPO);
    }

    @Override
    public int deleteLink(Integer id) {
        return linkDAO.deleteLink(id);
    }

    @Override
    public int addLink(LinkPO linkPO) {
        return linkDAO.addLink(linkPO);
    }

    @Override
    public Long getLinkCount() {
        return linkDAO.getLinkCount();
    }
}
