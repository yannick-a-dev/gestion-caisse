package com.bcaisse.bcaisse.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "vente")
public class Vente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int annee;
	private int numero;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private Date date_mvt;
	private String nom;
	private String adresse;
	private String ville;
	private String codep;
	private String tel;
	private String tel1;
	private double totht;
	private double tottva;
	private double totttc;
	private String modreg;
	private String numcarte;
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "vente", fetch = FetchType.EAGER)
	private List<Lvente> lventes = new ArrayList<>();
}
