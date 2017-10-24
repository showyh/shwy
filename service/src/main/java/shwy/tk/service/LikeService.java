package shwy.tk.service;

/**
 * Created by shwy on 2017/10/23.
 */
public interface LikeService {

    Long getLikeCount();

    int addLike(String userIP);

    Long getTodayLike();
}
