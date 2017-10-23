package shwy.tk.service;

/**
 * Created by shwy on 2017/4/15.
 */
public interface LikeService {

    Long getLikeCount();

    int addLike(String userIP);

    Long getTodayLike();
}
