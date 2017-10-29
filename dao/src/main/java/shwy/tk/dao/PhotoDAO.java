package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;
import shwy.tk.pojo.po.PhotoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/25.
 */
public interface PhotoDAO {
    List<PhotoPO> listPhoto(HashMap<String, Object> param);
    Long getPhotoCount(HashMap<String, Object> param);
    PhotoPO getPhoto(@Param("photoId") Integer photoId);

}
