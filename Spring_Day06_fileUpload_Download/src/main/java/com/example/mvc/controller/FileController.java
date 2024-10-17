package com.example.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	// spring 에서 파일이나 클래스 등을 리소스 로드할 때 사용 가능한 interface 
	@Autowired
	private ResourceLoader resourceLoader;
	
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		System.out.println(file.getOriginalFilename());
		
		// file 이 null 이 아닌 건지 확인 
		if(file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			// static 하위에 있는 img 폴더를 가지고 와야 한다. 
			//로컬 컴퓨터 내부 파일을 받고 싶다면 file: 로 시작해서 쓰면 된다. 
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			
			file.transferTo(new File(resource.getFile(), fileName)); 
			
			model.addAttribute("fileName", fileName);
		}
		
		return "result";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		
		return "fileDownloadView";
	}
	
	
	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		
		return "multiFileForm";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("file") MultipartFile[] files, Model model) throws IllegalStateException, IOException {
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		return "result";
	}
	
}
