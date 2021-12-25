/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.saad.tpbanque.managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import ma.emsi.saad.tpbanque.ejb.GestionnaireCompte;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@Named(value = "ajouter")
@RequestScoped
public class Ajouter {
    private String nom;
    private int solde;
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    /**
     * Creates a new instance of Ajouter
     */
    public Ajouter() {
    }
    public String  ajouter(){
        gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
        return "listeComptes?faces-redirect=true";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    
}
