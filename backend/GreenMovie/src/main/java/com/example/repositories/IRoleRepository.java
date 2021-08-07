package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{

}
