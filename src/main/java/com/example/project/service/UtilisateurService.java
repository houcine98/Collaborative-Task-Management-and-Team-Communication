package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.model.Utilisateur;
import com.example.project.repository.UtilisateurRepo;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepo utilisateurrepo;
	
	public List<Utilisateur> FindAllUser(){
    List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurrepo.findAll();
    	return utilisateurs ;
	}
	public Utilisateur addUser( String name , String prenom) {
		Utilisateur utilisateur = new Utilisateur();
		String role;
		role ="admin";
		utilisateur.setNom(name);
		utilisateur.setPrenom(prenom);
		utilisateur.setRole(role);
        return utilisateurrepo.save(utilisateur);
    }
	public void  DeleteUser (int id )
	{
		Long longId = Long.valueOf(id);
		utilisateurrepo.deleteById(longId);
	}
	public Utilisateur UpdateUser (int id)
	{
		Long longId = Long.valueOf(id);
		Utilisateur utilisateur = utilisateurrepo.findById(longId).orElse(null);
		return utilisateur ;
	}
}
