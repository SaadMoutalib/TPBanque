/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.saad.tpbanque.managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import ma.emsi.saad.tpbanque.ejb.GestionnaireCompte;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@Named(value = "compteDetail")
@ViewScoped
public class CompteDetail implements Serializable{
    private Long idCompte;
    private CompteBancaire compteBanquaire;
    /**
     * Creates a new instance of CompteDetail
     */
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    public CompteDetail() {
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompteBanquaire() {
        return compteBanquaire;
    }

    public void setCompteBanquaire(CompteBancaire compteBanquaire) {
        this.compteBanquaire = compteBanquaire;
    }
    
    public String update(){
        compteBanquaire = gestionnaireCompte.update(compteBanquaire);
        return "listeComptes?faces-redirect=true";
    }
    public void loadCompteBancaire() {
        this.compteBanquaire = gestionnaireCompte.getCompteBancaire(idCompte);
    }
   
}
