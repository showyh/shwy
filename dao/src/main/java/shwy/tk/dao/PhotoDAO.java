package shwy.tk.dao;

import shwy.tk.pojo.po.PhotoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/25.
 */
public interface PhotoDAO {
    List<PhotoPO> listPhoto(HashMap<String, Object> param);

    Long getPhotoCount(HashMap<String, Object> param);

    int updatePhoto(PhotoPO photoPO);

    int addPhoto(PhotoPO photoPO);

    PhotoPO getPhoto(Integer id);

    int deletePhoto(Integer id);

    List<PhotoPO> listAllPhoto();
}
