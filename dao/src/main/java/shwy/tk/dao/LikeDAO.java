package shwy.tk.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by shwy on 2017/10/23.
 */
public interface LikeDAO {

    Long getLikeCount();

    int addLike(@Param("userIP") String userIP);

    Long getTodayLike(@Param("today") String today);
}
