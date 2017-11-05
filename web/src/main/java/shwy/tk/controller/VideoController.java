package shwy.tk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shwy on 2017/11/3.
 */
@Controller
public class VideoController {

    @RequestMapping(value = {"/video"})
    public String VideoPage() {
        return "foreground/video";
    }
}
