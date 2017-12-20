package shwy.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author showy on 2017/10/15.
 * @version 1.0
 */

/* 使用Springboot自带的Tomcat*/
@SpringBootApplication
public class ShwyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShwyApplication.class, args);
    }
}

/*使用第三方的Tomcat*/
/*
@SpringBootApplication
public class ShwyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShwyApplication .class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShwyApplication .class, args);
    }
}
*/
