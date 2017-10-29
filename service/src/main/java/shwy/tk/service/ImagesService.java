package shwy.tk.service;

import shwy.tk.pojo.vo.ImagesVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/27.
 */
public interface ImagesService {

    List<ImagesVO> listImages(HashMap<String, Object> param);
    Long getImagesCount(HashMap<String, Object> param);
}
