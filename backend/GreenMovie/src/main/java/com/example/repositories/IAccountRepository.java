package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.AccountEntity;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long>{
	
	Optional<AccountEntity> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	@Query("select count(a) from AccountEntity a where a.role.code = :role and"
			+ " month(a.createdDate) <= :month and year(a.createdDate) <= :year")
	Long countByRoleInMonth(@Param("role")String role, @Param("month")int month, @Param("year")int year);
}
