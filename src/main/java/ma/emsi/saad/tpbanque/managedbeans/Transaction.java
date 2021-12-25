/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.saad.tpbanque.managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ma.emsi.saad.tpbanque.ejb.GestionnaireCompte;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@Named(value = "transaction")
@ViewScoped
public class Transaction implements Serializable{

    private Long idCompte;
    private CompteBancaire compteBanquaire;
    private int mnt;
    private String typeMouvement;
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of Transaction
     */
    public Transaction() {
    }

    public void loadCompteBancaire() {
        this.compteBanquaire = gestionnaireCompte.getCompteBancaire(idCompte);
    }

    public String enregistrerTransction() {
        if (typeMouvement.equals("deposer")) {
            gestionnaireCompte.deposer(compteBanquaire, mnt);
        } else {
            gestionnaireCompte.retirer(compteBanquaire, mnt);
        }
        Util.addFlashInfoMessage("Mouvement enregistré sur compte de " + compteBanquaire.getNom());
        return "listeComptes?faces-redirect=true";
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

    public CompteBancaire getCompteBanquaire() {
        return compteBanquaire;
    }

    public void setCompteBanquaire(CompteBancaire compteBanquaire) {
        this.compteBanquaire = compteBanquaire;
    }

    public int getMnt() {
        return mnt;
    }

    public void setMnt(int mnt) {
        this.mnt = mnt;
    }

    public String getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }
    
    

}
