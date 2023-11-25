package com.example.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.project.repository.UtilisateurRepo;
import com.example.project.service.UtilisateurService;
import com.example.project.model.Utilisateur;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	@Autowired
	UtilisateurService US ;
	
	@GetMapping("/list")
    public String listUtilisateurs(Model model) {
		
        model.addAttribute("utilisateurs", US.FindAllUser());
        return "utilisateur/utilisateur";
    }
	@GetMapping("/Add")
    public String showFormForAdd(Model model) {
        model.addAttribute("Utilisateur", new Utilisateur());
        return "utilisateur/AddForm";
    }

	@PostMapping("/save")
	public String saveEmployee(@RequestParam("nom") String name, @RequestParam("prenom") String prenom) {
	    Utilisateur utilisateur = US.addUser(name, prenom);
	    return "redirect:/utilisateurs/list";
	}


	@GetMapping("/FormUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") int id, Model model) {
	    Utilisateur utilisateur = US.UpdateUser(id);
	    model.addAttribute("utilisateur", utilisateur);
	    return "utilisateur/Updateform";
	}

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@RequestParam("id") int id) {
    	US.DeleteUser(id);
        return "redirect:/utlisateurs/list";
    }
}
