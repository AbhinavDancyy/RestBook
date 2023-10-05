package com.springboot.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
	
	public boolean uploadfile (MultipartFile file)
	{
		final String UPLOAD_DIR = "C:\\Projects\\Maven\\Boot\\RestBook\\src\\main\\resources\\static\\Images";
		boolean flag = false;
		 /** FileOutputStream fos = null;
		InputStream inputStream = null;
		try {
			 inputStream = file.getInputStream();
			 byte[] data = new byte[inputStream.available()];
			 fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
			fos.write(data);	
			flag = true;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					if(fos != null)
						fos.flush();
						fos.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("The Stream is not closed.");
				}
				
				try {
					if(inputStream != null)
						inputStream.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("The Stream is not closed.");
				}
			} */
		
		try {
			Files.copy(file.getInputStream(),Path.of(UPLOAD_DIR + File.separator + file.getOriginalFilename()));
			flag = true;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
					
		return flag;
	}
	

}
