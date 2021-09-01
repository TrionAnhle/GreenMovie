package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.ReceiptEntity;

@Repository
public interface IReceiptRepository extends JpaRepository<ReceiptEntity, Long>{
	@Query("from ReceiptEntity r where r.customer.id = :id order by r.createdDate desc")
	List<ReceiptEntity> findAllByCustomerId(@Param("id")Long id);
	
	@Query("from ReceiptEntity r where month(r.createdDate) = :month and year(r.createdDate) = :year")
	List<ReceiptEntity> findAllInMonth(@Param("month")int month, @Param("year")int year);
}
