package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.AccountEntity;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long>{

}
