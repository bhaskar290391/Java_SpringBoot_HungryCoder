package com.example.books.controller;

import java.io.File;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		
		try {
			file.transferTo(new File("‪C:\\Users\\A_R_COMPUTERS\\Desktop\\Bhaskar_File\\" +file.getOriginalFilename()));
			return "File Uploaded Successfully "+file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "File Upload is failed by original file" + file.getOriginalFilename(); 
		}
	}
}
