package shwy.tk.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shwy on 2017/10/20.
 */
@Component
public class QiNiuUploadUtil {

    private static String BUCKET_NAME = "showy"; //要上传的空间
    private static String ACCESS_KEY = "yjjl3q6Qb8vihdJSvPAfX3HE6v-efI-KuSFoCdz1"; //这两个登录七牛 账号里面可以找到
    private static String SECRET_KEY = "f0WE2UVfzT8Hl6sMYlVM0rujnGDbSg8iRo-eQkc3";

    //普通上传
    public static boolean upload(InputStream in, String key) {
        //调用put方法上传
        Response res = null;
        try {
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager(new Configuration());
            //获取上传策略
            String token = auth.uploadToken(BUCKET_NAME);
            res = uploadManager.put(in, key, token, null, null);
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res.isOK();
    }

    public static boolean upload(byte[] data, String key) {
        //调用put方法上传
        Response res = null;
        try {
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager(new Configuration());
            //获取上传策略
            String token = auth.uploadToken(BUCKET_NAME);
            res = uploadManager.put(data, key, token);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return res.isOK();
    }


}
