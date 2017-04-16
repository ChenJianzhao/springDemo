package org.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by jzchen on 2017/2/8 0008.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "name") String name,
                         @RequestParam(value = "file")MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            file.transferTo(new File("D:/upload/" + file.getOriginalFilename()));
            return "redirect:uploadResult";
        }else
            return "redirect:uploadResult";
    }
}
