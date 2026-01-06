package com.firstproj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReactForwardController {

    // Forward all routes that do NOT contain a dot (.)
    // and are not handled by another controller
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String forward() {
        // This tells Spring to forward to index.html under resources/static
        return "forward:/index.html";
    }
}
