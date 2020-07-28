
package com.example.demo.web;


import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class CategoryController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
		Product p = productRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(
				System.getProperty("user.home") 
				+ "/ecom/" + p.getPhotoName()
				)
				);
	}
	
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file, @PathVariable("id") Long id) throws Exception {
		Product p = productRepository.findById(id).get();
		p.setPhotoName(id+".png");
		Files.write(Paths.get(
				System.getProperty("user.home") 
				+ "/ecom/" + p.getPhotoName()), file.getBytes() );
		productRepository.save(p);
		
	}
	
//	@@GetMapping(path = "/categories/{id}")
//	public Page<Product> getPage(@PathVariable("id") Long id) throws Exception {
//		
//	}
}
