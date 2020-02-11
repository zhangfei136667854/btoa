package com.situ.btoa.fileUpload.service;

import javax.servlet.http.HttpServletRequest;

import com.situ.btoa.fileUpload.domain.UploadFile;

public interface UploadFileServicesss {
	String getFileImg(UploadFile uploadFile, HttpServletRequest request);
}
