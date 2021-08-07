package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ReceiptEntity;

@Repository
public interface IReceiptRepository extends JpaRepository<ReceiptEntity, Long>{

}
