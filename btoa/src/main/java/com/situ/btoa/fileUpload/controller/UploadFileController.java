package com.situ.btoa.fileUpload.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.btoa.commons.LayuiResult;
import com.situ.btoa.fileUpload.domain.UploadFile;
import com.situ.btoa.fileUpload.service.UploadFileServicesss;

@Controller
public class UploadFileController {
	@Autowired
	private UploadFileServicesss uploadFileServicess ;
	@RequestMapping("/upload")
	@ResponseBody
	public LayuiResult uploadFile(UploadFile uploadFile, HttpServletRequest request) {
		System.out.println(uploadFile);
		System.out.println(uploadFile.getUploadFile());
		
		String src =uploadFileServicess.getFileImg(uploadFile, request) ;
		return new LayuiResult("",src,0);
	}

}
