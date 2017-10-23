package shwy.tk.service;

import shwy.tk.pojo.po.LinkPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface LinkService {

    List<LinkPO> listLink(HashMap<String, Integer> param);

    int updateLink(LinkPO linkPO);

    int deleteLink(Integer id);

    int addLink(LinkPO linkPO);

    Long getLinkCount();
}
