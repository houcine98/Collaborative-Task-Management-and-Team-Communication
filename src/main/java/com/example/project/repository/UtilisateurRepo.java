package com.example.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.project.model.Utilisateur;

public interface UtilisateurRepo extends CrudRepository<Utilisateur,
Long> {

}