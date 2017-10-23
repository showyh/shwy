package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.MottoDAO;
import shwy.tk.pojo.po.MottoPO;
import shwy.tk.service.MottoService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
@Service("mottoService")
public class MottoServiceImpl implements MottoService {

    @Autowired
    private MottoDAO mottoDAO;

    @Override
    public MottoPO getMotto() {
        return mottoDAO.getMottoPO();
    }

    @Override
    public int updateMotto(MottoPO mottoPO) {
        return mottoDAO.updateMotto(mottoPO);
    }

    @Override
    public int addMotto(MottoPO mottoPO) {
        return mottoDAO.addMotto(mottoPO);
    }

    @Override
    public int deleteMotto(Integer id) {
        return mottoDAO.deleteMotto(id);
    }

    @Override
    public Long getMottoCount() {
        return mottoDAO.getMottoCount();
    }

    @Override
    public List<MottoPO> listMotto(HashMap<String, Integer> param) {
        return mottoDAO.listMotto(param);
    }
}
