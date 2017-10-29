package shwy.tk.pojo.po;

/**
 * Created by shwy on 2017/10/27.
 */
public class ImagesPO {
    private Integer id;
    private String imageName;
    private String imageUrl;
    private Integer photoId;
    private PhotoPO photoPO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public PhotoPO getPhotoPO() {
        return photoPO;
    }

    public void setPhotoPO(PhotoPO photoPO) {
        this.photoPO = photoPO;
    }

}
