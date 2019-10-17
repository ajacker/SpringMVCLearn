package com.ajacker.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author ajacker
 * @date 2019/10/17 22:33
 */
@Controller
@RequestMapping("/fileUpload")
public class FileController {
    @RequestMapping("/uploadHandler")
    public String handleUpload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //判断路径不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历创建文件
        fileItems.removeIf(FileItem::isFormField);
        for (FileItem fileItem : fileItems) {
            String fileName = fileItem.getName();
            //文件名称设置唯一值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + "_" + fileName;
            fileItem.write(new File(path, fileName));
            //删除临时文件
            fileItem.delete();
        }
        return "success";
    }

    @RequestMapping("/mvcUploadHandler")
    public String mvcHandleUpload(HttpServletRequest request, @RequestParam("fileParam") MultipartFile upload) throws Exception {
        System.out.println("文件上传");
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //判断路径不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = upload.getOriginalFilename();
        //文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + "_" + fileName;
        upload.transferTo(new File(path, fileName));
        return "success";
    }

    @RequestMapping("/betweenUploadHandler")
    public String betweenHandleUpload(@RequestParam("fileParam") MultipartFile upload) throws Exception {
        //文件上传服务器包
        String path = "http://127.0.0.1:9090/uploads/";
        String fileName = upload.getOriginalFilename();
        //文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + "_" + fileName;
        //创建客户端
        Client client = Client.create();
        //连接图片服务器
        WebResource resource = client.resource(path + fileName);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
