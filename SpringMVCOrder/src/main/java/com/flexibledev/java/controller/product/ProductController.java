package com.flexibledev.java.controller.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.flexibledev.java.exception.ImageUploadException;
import com.flexibledev.java.model.ProductModel;
import com.flexibledev.java.service.ProductService;

@Controller
@RequestMapping(value = "/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("product") ProductModel model, 
			BindingResult bindingResult,
			@RequestParam(value="image", required = false) MultipartFile image,
			HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		
		if (!image.getContentType().equals("image/jpeg") || !image.getContentType().equals("image/jpg")) {
			throw new ImageUploadException("JPEG 이미지만 선택해주세요.");
		}
		
		try {
			if (!image.isEmpty()) {
				String webRootPath = request.getSession().getServletContext().getRealPath("/");
				String filePath = webRootPath + "resources/" + image.getOriginalFilename();
				File file = new File(filePath);
				FileUtils.writeByteArrayToFile(file, image.getBytes());
				// TODO: remove comment to write logger
				// logger.info("Upload File : " + filePath);
			}
		} catch (Exception e) {
			bindingResult.reject(e.getMessage());
			return "edit";
		}
		
		productService.saveProduct(model.buildDomain());
		
		return "result";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public void list(Model model) {
		// TODO: 
	}
}
