package shwy.tk.dao;

import shwy.tk.pojo.po.MottoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface MottoDAO {

    MottoPO getMottoPO();

    int updateMotto(MottoPO mottoPO);

    int addMotto(MottoPO mottoPO);

    int deleteMotto(Integer id);

    Long getMottoCount();

    List<MottoPO> listMotto(HashMap<String, Integer> param);
}
