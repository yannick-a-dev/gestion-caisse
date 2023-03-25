package com.bcaisse.bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaisse.bcaisse.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
