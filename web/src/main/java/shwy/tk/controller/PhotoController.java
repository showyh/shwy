package shwy.tk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shwy on 2017/10/24.
 */
@Controller
public class PhotoController {
    @RequestMapping(value = {"/photo"})
    public String MusicPage(){
        return "photo";
    }
}
