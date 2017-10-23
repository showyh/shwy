package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.LinkPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface LinkDAO {

    List<LinkPO> listLinkPO(HashMap<String, Integer> param);

    int updateLink(LinkPO linkPO);

    int deleteLink(@Param("id") Integer id);

    int addLink(LinkPO linkPO);

    Long getLinkCount();
}
