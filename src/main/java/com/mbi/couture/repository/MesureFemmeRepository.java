package com.mbi.couture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mbi.couture.entity.Mesure;
import java.util.List;
import com.mbi.couture.entity.Client;


@Repository
public interface MesureFemmeRepository extends JpaRepository<Mesure,Long>{
    Mesure findByClient(Client client);
}