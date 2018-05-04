package com.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author 笑笑
 * @Date 21:28 2018/05/02
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index")
    public String showIndex(Model model){
        model.addAttribute("Say","你好 FreeMarker!");
        return "index";
    }
}
