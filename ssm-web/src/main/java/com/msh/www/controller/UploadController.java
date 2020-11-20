package com.msh.www.controller;


import com.msh.www.http.AxiosResult;
import com.msh.www.upload.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author dn26
 */
@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("upload")
    public AxiosResult upload(@RequestPart("file") Part part) throws IOException {

        return AxiosResult.success(uploadService.upload(part.getInputStream(),part.getSubmittedFileName(),part.getSize()));
    }
}
