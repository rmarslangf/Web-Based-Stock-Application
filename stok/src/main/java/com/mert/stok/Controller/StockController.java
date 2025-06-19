package com.mert.stok.Controller;

import com.mert.stok.Model.Product;
import com.mert.stok.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home/stock")
@RequiredArgsConstructor
public class StockController {
    private final ProductService productService;
    //ürün listeleme alanı
    @GetMapping
    public String stockPage(Model model) {
        List<Product> products = productService.getAllProducts();
        log.info("Bulunan ürün sayısı: {}", products.size());
        model.addAttribute("products", products);
        return "stock";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    //ürün ekelme alanı
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            log.info("Yeni ürün ekleniyor - Gelen veri: {}", product);
            
            if (product.getName() == null || product.getName().trim().isEmpty()) {
                log.error("Ürün adı boş olamaz");
                return ResponseEntity.badRequest().body("Ürün adı boş olamaz");
            }
            
            if (product.getPrice() == null || product.getPrice() <= 0) {
                log.error("Geçersiz fiyat: {}", product.getPrice());
                return ResponseEntity.badRequest().body("Geçersiz fiyat");
            }
            
            if (product.getStockQuantity() == null || product.getStockQuantity() < 0) {
                log.error("Geçersiz stok miktarı: {}", product.getStockQuantity());
                return ResponseEntity.badRequest().body("Geçersiz stok miktarı");
            }

            Product savedProduct = productService.saveProduct(product);
            log.info("Ürün başarıyla kaydedildi: {}", savedProduct);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            log.error("Ürün eklenirken hata oluştu", e);
            return ResponseEntity.internalServerError().body("Ürün eklenirken bir hata oluştu: " + e.getMessage());
        }
    }
    //ürün silme alanı
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            log.info("Ürün siliniyor, ID: {}", id);
            productService.deleteProduct(id);
            log.info("Ürün başarıyla silindi, ID: {}", id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ürün silinirken hata oluştu", e);
            return ResponseEntity.internalServerError().body("Ürün silinirken bir hata oluştu: " + e.getMessage());
        }
    }
} 