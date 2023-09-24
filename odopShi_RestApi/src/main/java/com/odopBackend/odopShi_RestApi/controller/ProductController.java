package com.odopBackend.odopShi_RestApi.controller;

import com.odopBackend.odopShi_RestApi.Entity.Product;
import com.odopBackend.odopShi_RestApi.repository.ProductRepository;
import com.odopBackend.odopShi_RestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProductToInventory(@ModelAttribute Product product, @RequestParam("image") MultipartFile file) {
        return productService.addProduct( product,file);

    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadPic(@ModelAttribute Product product,@RequestParam("image") MultipartFile file) throws IOException {
//        Product pro = new Product();
//        // pic.setName(file.getOriginalFilename());
//        // pic.setType(file.getContentType());
//        pro.setImage(file.getBytes());
//        pro.setPrice(product.getPrice());
//        pro.setProductId(product.getProductId());
//        pro.setCategory(product.getCategory());
//        pro.setDistrict(product.getDistrict());
//        pro.setProductOwner(product.getProductOwner());
//        pro.setDescriptions(product.getDescriptions());
//
//        repository.save(pro);
//
//        return ResponseEntity.ok("Image uploaded successfully!");
//    }

    @GetMapping("/getAll/{adminUserId}")
    public List<Product> getAllProduct(@PathVariable Long adminUserId){
        return productService.getAdminInventory(adminUserId);
    }

    @DeleteMapping("delete/{productId}")
    public String deleteProductByid(@PathVariable Long productId){
        return productService.deleteByProductId(productId);
    }
}
