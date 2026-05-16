package com.example.books.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/files")
public class FileController {

	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile file) {

		try {
			Path path = Paths.get("C:/Users/A_R_COMPUTERS/Desktop/Bhaskar_File/" + file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			return "File Uploaded Successfully " + file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "File Upload is failed by original file" + file.getOriginalFilename();
		}
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName){
		
		try {
			File file=new File("C:/Users/A_R_COMPUTERS/Desktop/Bhaskar_File/"+ fileName);
			byte[] fileContent=Files.readAllBytes(file.toPath());
			
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment",fileName);
			return new ResponseEntity<byte[]>(fileContent, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
