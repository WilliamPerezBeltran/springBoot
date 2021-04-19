package com.restdemo.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
//	http://localhost:8080/hello
//	curl http://localhost:8080/getProducts
	@RequestMapping("/getProduct")
	public Product getProduct(){
		return new Product(1,"phone",99.9f);
	}
//	http://localhost:8080/helloWithRequestParam?fileName=william
	@RequestMapping("/getProducts")
	public List<Product> getProducts(){
		Product product1,product2,product3,product4;
		List<Product> products = new ArrayList<Product>();
		product1 = new Product(1,"phone",939.9f);
		product2 = new Product(2,"huawei",949.3f);
		product3 = new Product(3,"mac",129.5f);
		product4 = new Product(4,"lapton",29.7f);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product4);
		return products;
		
				
	}
	/*
	 * handle different http methods
		@getMapping
		@PostMapping
		@PutMapping
		@DeleteMapping
	 * */	
//	write json data to response 
//	Read json data from request
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Product product){
		System.out.println(product);
	}
	
//	Specify content type of request/response	
//	el content type es esta partecita => MediaType.TEXT_HTML_VALUE
//	especifica el tipo de contenido 
//	curl -H "Content-type: text/html" http://localhost:8080/getProductWithGetMapping
	@GetMapping(value="/getProductWithGetMapping", consumes= {MediaType.TEXT_HTML_VALUE})
	public Product getProductContentType(){
		return new Product(2,"huawei",949.3f);
	}
	
	@GetMapping(
			value="/getProductWithGetMapping1",
			produces = {MediaType.TEXT_HTML_VALUE}
			)
	public String getProductWithGetMapping1(){
		return "<html><body>REST SPRING BOOT</body></html>";
	}
	
	@GetMapping(
			value="/getProductWithGetMapping2", 
			produces = {MediaType.TEXT_XML_VALUE}
			)
	public String getProductWithGetMapping2(){
		return "<product></product>";
	}
	
	//	Specify HTTP status code	
//	curl -v http://localhost:8080/product/3

	@GetMapping(
			value="/product/{id}", 
			produces = {MediaType.TEXT_XML_VALUE}
			)
	public ResponseEntity<Product> getProduct2(@PathVariable int id){
		if(id == 3) {
			System.out.println("entro al if");
			Product product = new Product(3,"huawaei",234.26f);
			return new ResponseEntity<Product>(HttpStatus.OK);			
		}else {
			System.out.println("entro al else");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); 
		}
	}
	
//	curl -v http://localhost:8080/product/1
//esto genera una mierda algo como esto: 
//	
//	user@user-Z390-GAMING-X ~ $ curl -v http://localhost:8080/product/1
//		*   Trying 127.0.0.1...
//		* TCP_NODELAY set
//		* Connected to localhost (127.0.0.1) port 8080 (#0)
//		> GET /product/1 HTTP/1.1
//		> Host: localhost:8080
//		> User-Agent: curl/7.60.0
//		> Accept: */*
//		> 
//		< HTTP/1.1 404 
//		< Content-Length: 0
//		< Date: Mon, 12 Apr 2021 20:55:27 GMT
//		< 
//
//	
//	
	
	
}
