package com.zhanghe.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.zhanghe.fast.starter.util.ReturnValue;
@Controller
public class uploadController {

	//@CrossOrigin()
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request) throws IllegalStateException, IOException{
		 //文件上传的请求
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        //获取请求的参数
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();
        //用hasNext() 判断是否有值，用next()方法把元素取出。
        while(it.hasNext()){
             Map.Entry<String, MultipartFile> entry = it.next();
             MultipartFile mFile = entry.getValue();
             System.out.println(entry.getKey());
             if(mFile.getSize() != 0 && !"".equals(mFile.getName())){
                 mFile.transferTo(new File("F:\\"+mFile.getOriginalFilename()));
             }
        }
		System.out.println("upload");
		return new ReturnValue<Object>(1,"").toJson();
	}
	
	//@CrossOrigin()
	@RequestMapping("/upload2")
	@ResponseBody
	public String upload( MultipartFile hello) throws IllegalStateException, IOException{
        hello.transferTo(new File("F:\\"+hello.getOriginalFilename()));
		System.out.println("upload2");
		return new ReturnValue<Object>(1,"").toJson();
	}
	
	//@CrossOrigin()
	@RequestMapping("/uploadfiles")
	@ResponseBody
	public String upload( MultipartFile[] hellos) throws IllegalStateException, IOException{
		System.out.println(hellos.length);
		for(MultipartFile hello:hellos){
	        hello.transferTo(new File("F:\\"+hello.getOriginalFilename()));	
		}
		System.out.println("uploadfiles");
		return new ReturnValue<Object>(1,"").toJson();
	}
}
