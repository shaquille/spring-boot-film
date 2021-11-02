package com.training.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Acteur {

	@Id
	@Column (name="acteur_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="film_id")
//	@JsonIgnore
//	private Film film;
	@JsonIgnore
	@ManyToMany(mappedBy = "acteurs", fetch = FetchType.LAZY)
	private Set<Film> films = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Film> getFilms() {
		return films;
	}
	
	public void setFilms(Set<Film> films) {
		this.films = films;
	} 
	

	@Override
	public String toString() {
		return "Acteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	
	
}
