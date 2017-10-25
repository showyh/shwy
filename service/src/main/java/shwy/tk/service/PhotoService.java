package shwy.tk.service;

import shwy.tk.pojo.po.PhotoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/25.
 */
public interface PhotoService {

    List<PhotoPO> listPhoto(HashMap<String, Object> param);

    Long getPhotoCount(HashMap<String, Object> param);
}
