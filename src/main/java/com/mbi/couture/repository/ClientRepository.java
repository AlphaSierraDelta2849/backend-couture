package com.mbi.couture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbi.couture.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
}