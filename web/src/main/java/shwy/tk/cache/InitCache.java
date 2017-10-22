package shwy.tk.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import shwy.tk.pojo.vo.BlogDateArchiveVO;
import shwy.tk.pojo.vo.BlogVO;
import shwy.tk.service.BlogService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
/**
 * Created by shwy on 2017/10/16.
 */
/**
 * 项目启动时就加载此类，将不常变的数据存进application，相当于缓存
 */
@Component
public class InitCache implements ServletContextListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();

        //获取service实例

        BlogService blogService = (BlogService) applicationContext.getBean("blogService");

        //调用service方法，取得数据

        List<BlogDateArchiveVO> blogDateArchiveList = blogService.listBlogDateArchive();

        BlogVO recommendBlog = blogService.getRecommendBlog();

        //将数据塞进application

        application.setAttribute("blogDateArchiveList", blogDateArchiveList);//博客日期归档;
        application.setAttribute("recommendBlog", recommendBlog);//推荐博客;

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
