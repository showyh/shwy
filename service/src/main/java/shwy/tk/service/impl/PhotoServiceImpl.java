package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.ImagesDAO;
import shwy.tk.dao.PhotoDAO;
import shwy.tk.pojo.po.ImagesPO;
import shwy.tk.pojo.po.PhotoPO;
import shwy.tk.service.PhotoService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/25.
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private PhotoDAO photoDAO;
    @Autowired
    private ImagesDAO imagesDAO;
    @Override
    public List<PhotoPO> listPhoto(HashMap<String, Object> param) {
        List<PhotoPO> photoPOList = photoDAO.listPhoto(param);
        return photoPOList;
    }

    @Override
    public Long getPhotoCount(HashMap<String, Object> param) {
        return photoDAO.getPhotoCount(param);
    }

    @Override
    public int updatePhoto(PhotoPO photoPO) {
        return photoDAO.updatePhoto(photoPO);
    }

    @Override
    public int addPhoto(PhotoPO photoPO) {
        return photoDAO.addPhoto(photoPO);
    }

    @Override
    public PhotoPO getPhoto(Integer id) {
        return photoDAO.getPhoto(id);
    }


    @Override
    public int deletePhoto(Integer id) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("photoId", id.toString());
        List<ImagesPO> imagesList = imagesDAO.listImagesPO(param);
        if (imagesList.size() > 0) {
            return 0;
        }
        return photoDAO.deletePhoto(id);
    }

    @Override
    public List<PhotoPO> listAllPhoto() {
        return photoDAO.listAllPhoto();
    }

}
