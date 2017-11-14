package shwy.tk.dao;

import shwy.tk.pojo.po.ImagesPO;
import shwy.tk.pojo.vo.ImagesVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/27.
 */
public interface ImagesDAO {
    List<ImagesVO> listImages(HashMap<String, Object> param);

    Long getImagesCount(HashMap<String, Object> param);

    int updateImage(ImagesPO imagesPO);

    int deleteImage(Integer id);

    ImagesPO getImage(int id);

    int addImage(ImagesPO imagesPO);

    List<ImagesPO> listImagesPO(HashMap<String, Object> param);
}
