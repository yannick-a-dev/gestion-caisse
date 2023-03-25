package com.bcaisse.bcaisse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "categorie")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String code_b;
	private String libelle;
	private float pa;
	private float pv;
	private int fodec;
	private int stock;
	private int stkinit;
	private String ccateg;
	private String cscateg;
	private String fileName;
	private int qte;
}
