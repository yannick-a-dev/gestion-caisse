package com.bcaisse.bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaisse.bcaisse.entity.Lvente;

@Repository
public interface LventeRepository extends JpaRepository<Lvente, Long> {

}
