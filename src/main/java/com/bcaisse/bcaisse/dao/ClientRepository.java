package com.bcaisse.bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaisse.bcaisse.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
