package mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author
 * @description: 测试文件的上传和下载
 * @create 2022/5/6-18:59
 */
@RestController
//@RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，
// 就相当于为类添加了@Controller注解，并且为其中的每个方法添加了@ResponseBody注解
public class fileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/a3.png");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组 is.available()获取文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=a3.png");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/fileUP")
    public String testFileUP(MultipartFile photo,HttpSession session) throws IOException {
        System.out.println(photo.getOriginalFilename());
        //获取上传的文件的文件名
        String filename = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = filename.substring(filename.lastIndexOf("."));
        //将UUID作为文件名
        filename = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");
        //在服务器中如果没有photo这层目录，那就创建这个目录
        File file1 = new File(realPath);
        if(!file1.exists()){
            file1.mkdir();//创建目录
        }
        //File.separator 路径分割符
        String finalPath=realPath+File.separator+filename;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }
}


