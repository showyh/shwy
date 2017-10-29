package shwy.tk.dao;

import shwy.tk.pojo.vo.ImagesVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/27.
 */
public interface ImagesDAO {
    List<ImagesVO> listImages(HashMap<String, Object> param);

    Long getImagesCount(HashMap<String, Object> param);
}
