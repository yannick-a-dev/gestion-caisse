package com.bcaisse.bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaisse.bcaisse.entity.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Long> {

}
