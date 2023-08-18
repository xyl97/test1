package com.wojia.springboot.boot2.controller;


import ch.qos.logback.core.util.FileUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wojia.springboot.boot2.pojo.Emp;
import com.wojia.springboot.boot2.pojo.FileInfo;
import com.wojia.springboot.boot2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;

    private static String fileUploadRootDir = null;
    @Value("${web.upload.path}")
    private String staticPath;

   String fileUploadRootDirWindows;

    private static Map<String,Emp> fileRepository = new HashMap<>();



//    public void initFileRepository() throws IOException {
    //
    //    @PostConstruct
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateNowStr = sdf.format(d);
//        // 判断文件夹是否存在，不存在就创建
//        String osName = System.getProperty("os.name");
//        if (osName.startsWith("Windows")) {
//            // windows
//            fileUploadRootDir = fileUploadRootDirWindows+dateNowStr+"/";
//        }
//
//    }


    @GetMapping("shwo")
    public String shwo(Model model, String username, @RequestParam(required = true,defaultValue = "1")Integer pageNum,
                       @RequestParam(required = false,defaultValue = "2") Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Emp> list = empService.show(username);
        PageInfo<Emp> page = new PageInfo<>(list);
        model.addAttribute("page",page);
   model.addAttribute("username",username);
        return "showkk";
    }

    @GetMapping("toid")
    public Emp showid(Integer id){

        return empService.showw(id);
    }
    @GetMapping("todelete")
    public String delete(Integer id){
        int delete = empService.delete(id);
        if (delete>0){
            return "redirect:shwo";
        }
        return "error";
    }
//    @GetMapping("xiugai")
//    public Emp update(Emp emp){
//        emp.setId(1);
//        emp.setUsername("未知");
//      empService.update(emp);
//
//    }


    @GetMapping("toupdate")
    public String  toupdate(Integer id,Model model){
       Emp emp  = empService.showw(id);
       model.addAttribute("emp",emp);
       return "empupdate";

    }
    @GetMapping("update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:shwo";
    }
    @GetMapping("toadd")
    public String toadd(){
        return "empadd";
    }

    @PostMapping(value="add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String add(Emp emp, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
       // Emp emp1 = new Emp();
       // String originalFilename = file.getOriginalFilename();
        request.getServletContext().getRealPath("/");
        String fileName = "";
        if (file!=null&&file.getSize()>0){
            String originalFilename = file.getOriginalFilename();
            originalFilename.substring(originalFilename.lastIndexOf("."));



        }
       // String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String s = UUID.randomUUID() + substring;
//         emp.setImg(originalFilename);

         //获取文件路径
        String path1 = new ClassPathResource("/static/img").getURL().getPath();
       // String path  =fileUploadRootDir;
      //   emp.setPath(path1);
       File convertFile = new File ( path1);

        FileOutputStream fileOutputStream = new FileOutputStream ( convertFile );
        fileOutputStream.write ( file.getBytes () );

       fileOutputStream.close ();
       fileRepository.put ( emp.getImg(),emp);

        empService.add(emp);
        return "redirect:shwo";
    }
}
