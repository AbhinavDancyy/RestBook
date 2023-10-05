package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		if(file.isEmpty())
		{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot upload a empty file..");
			
		}
		
		 if(file.getContentType().equals("jpeg/image"))
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg/image file is allowed...");
			
		 boolean b = this.fileUploadHelper.uploadfile(file);
		 if(b)
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("File is uploaded successfully...");
		 else
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethig went wrong try again...");
		
	}
	
}
