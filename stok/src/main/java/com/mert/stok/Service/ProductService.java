package com.mert.stok.Service;

import com.mert.stok.Model.Product;
import com.mert.stok.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    //Ürün getirme
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Veritabanından {} ürün getirildi", products.size());
        return products;
    }
    //ürün ekleme
    public Product saveProduct(Product product) {
        log.info("Ürün kaydediliyor: {}", product);
        Product savedProduct = productRepository.save(product);
        log.info("Ürün başarıyla kaydedildi: {}", savedProduct);
        return savedProduct;
    }
    //ürün silme
    public void deleteProduct(Long id) {
        log.info("Ürün siliniyor, ID: {}", id);
        productRepository.deleteById(id);
        log.info("Ürün başarıyla silindi, ID: {}", id);
    }
    //ID üzerinden ürün getirme
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
    }
} 