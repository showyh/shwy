package shwy.tk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shwy.tk.dao.ImagesDAO;
import shwy.tk.pojo.po.ImagesPO;
import shwy.tk.pojo.vo.ImagesVO;
import shwy.tk.service.ImagesService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/27.
 */
@Service("imagesService")
public class ImagesServiceImpl implements ImagesService{

    @Autowired
    private ImagesDAO imagesDAO;
    @Override
    public List<ImagesVO> listImages(HashMap<String, Object> param) {
        List<ImagesVO> imagesVOList=imagesDAO.listImages(param);
        return imagesVOList;
    }

    @Override
    public List<ImagesPO> listImagesPO(HashMap<String, Object> param) {
        return imagesDAO.listImagesPO(param);
    }

    @Override
    public Long getImagesCount(HashMap<String, Object> param) {
        return imagesDAO.getImagesCount(param);
    }


    @Override
    public ImagesPO getImage(int id) {
        return imagesDAO.getImage(id);
    }

    @Override
    public int deleteImage(Integer id) {
        return imagesDAO.deleteImage(id);
    }

    @Override
    public int updateImage(ImagesPO imagesPO) {
        return imagesDAO.updateImage(imagesPO);
    }

    @Override
    public int addImage(ImagesPO imagesPO) {
        return imagesDAO.addImage(imagesPO);
    }
}
