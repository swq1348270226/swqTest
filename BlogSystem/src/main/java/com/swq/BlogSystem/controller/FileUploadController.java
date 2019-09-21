package com.swq.BlogSystem.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.swq.BlogSystem.business.UserBusiness;

@Controller
public class FileUploadController {

	@Autowired
	UserBusiness userBusiness;

	/*
	 * @Autowired HttpServletRequest request;
	 */

@RequestMapping(value = "/upload",method=RequestMethod.POST)
@ResponseBody
public String upload(@RequestParam("uploadImg") MultipartFile multipartFile,HttpServletRequest request) {
	
	try {
		//获取项目路径
		/*String realPath = "G:\\eclipseWorkingSpace\\uploadImag";*/
		
		String realPath = "/appFile/upload/image";
		
		InputStream inputStream = multipartFile.getInputStream();
		String contextPath = request.getContextPath();
		//跟目录下新建文件夹upload，存放上传图片
		//获取文件名称
		String filename=getUploadPathFilename(multipartFile);
		
		File file =new File(realPath,filename);
		FileUtils.copyInputStreamToFile(inputStream, file);

		//返回图片访问路径
		String url = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + "/upload/" + filename;
		return url;
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

private String getUploadPathFilename(MultipartFile multipartFile) {
	
	String uploadFileName = multipartFile.getOriginalFilename();
	String fileName = uploadFileName.substring(0,uploadFileName.lastIndexOf("."));
	String type = uploadFileName.substring(uploadFileName.lastIndexOf("."));
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String time = sdf.format(new Date());
	String name =fileName +"_"+time +type;
	return name;
	
}
	

}
