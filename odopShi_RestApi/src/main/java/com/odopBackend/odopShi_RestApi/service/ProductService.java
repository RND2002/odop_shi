package com.odopBackend.odopShi_RestApi.service;

import com.odopBackend.odopShi_RestApi.Entity.Product;
import com.odopBackend.odopShi_RestApi.Entity.ProductOwnerShip;
import com.odopBackend.odopShi_RestApi.Entity.Users;
import com.odopBackend.odopShi_RestApi.repository.ProductOwnerShipRepository;
import com.odopBackend.odopShi_RestApi.repository.ProductRepository;
import com.odopBackend.odopShi_RestApi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final ProductOwnerShipRepository productOwnerShipRepository;

    public ProductService(UserRepository userRepository, ProductRepository productRepository, ProductOwnerShipRepository productOwnerShipRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productOwnerShipRepository = productOwnerShipRepository;
    }

//    public ResponseEntity<String> addProductTORepository(Product newProduct){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//
//        String userName= authentication.getName();
//        Users admin = userRepository.findByUsername(userName);
//
//
//        Product saveProduct=productRepository.save(newProduct);
//        ProductOwnerShip productOwnerShip=new ProductOwnerShip();
//        productOwnerShip.setUser(admin);
//        productOwnerShip.setProduct(newProduct);
//        productOwnerShipRepository.save(productOwnerShip);
//        return new ResponseEntity<>("Successfully Product added", HttpStatus.OK);
//    }


    public ResponseEntity<String> addProduct( Product product, MultipartFile file) {

        // Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        // String userName= authentication.getName();
        // Users admin = userRepository.findByUsername(userName);
       // Product pro=new Product();
        try {
            if (!file.isEmpty()) {
                byte[] imageData = file.getBytes();

                product.setImage(imageData);
                productRepository.save(product);
                ProductOwnerShip productOwnerShip=new ProductOwnerShip();
                productOwnerShip.setProduct(product);
                // productOwnerShip.setUser(admin);
                productOwnerShipRepository.save(productOwnerShip);
            } else {
                return new ResponseEntity<>("Error: No image file uploaded", HttpStatus.BAD_REQUEST);
            }

            // Process and save the product with the image in your database



            return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error uploading image", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public List<Product> getAdminInventory(Long adminUserId) {
        Users adminUser = userRepository.findById(adminUserId).orElseThrow(() -> new IllegalArgumentException("Admin user not found."));

        List<ProductOwnerShip> adminProductOwnerships = productOwnerShipRepository.findByUser(adminUser);

        return adminProductOwnerships.stream()
                .map(ProductOwnerShip::getProduct)
                .collect(Collectors.toList());
    }

    public String deleteByProductId(Long productId){
        productRepository.deleteById(productId);
        return "deleted successfully";

    }

}
