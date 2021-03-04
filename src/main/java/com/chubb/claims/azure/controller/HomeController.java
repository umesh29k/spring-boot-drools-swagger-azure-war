package com.chubb.claims.azure.controller;

import com.chubb.claims.azure.service.HomeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
	private final HomeService jewelleryShopService;

	@Autowired
	public HomeController(HomeService jewelleryShopService) {
		this.jewelleryShopService = jewelleryShopService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public com.chubb.claims.azure.model.Product getQuestions(@RequestParam(required = true) String type) {

		com.chubb.claims.azure.model.Product product = new com.chubb.claims.azure.model.Product();
		product.setType(type);

		jewelleryShopService.getProductDiscount(product);

		return product;
	}

	@GetMapping("/products") List<com.chubb.claims.azure.model.Product> all(){
		List<com.chubb.claims.azure.model.Product> pl = new ArrayList<>();
		com.chubb.claims.azure.model.Product p = new com.chubb.claims.azure.model.Product();
		p.setType("Test");
		p.setDiscount(12);
		pl.add(p);
		jewelleryShopService.getProductDiscount(p);
		return pl;
	}
}
