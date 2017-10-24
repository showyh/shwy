package shwy.tk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shwy on 2017/10/23.
 */
@Controller
public class MusicController {
    @RequestMapping(value = {"/music"})
    public String MusicPage(){
        return "foreground/music";
    }
}
