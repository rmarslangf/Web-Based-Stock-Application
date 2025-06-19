package com.mert.stok.Repository;

import com.mert.stok.Model.SaleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SaleLogRepository extends JpaRepository<SaleLog, Long> {
    List<SaleLog> findByProductIdOrderBySaleDateDesc(Long productId);
    
    @Query("SELECT sl FROM SaleLog sl ORDER BY sl.saleDate DESC")
    List<SaleLog> findAllOrderBySaleDateDesc();
} 