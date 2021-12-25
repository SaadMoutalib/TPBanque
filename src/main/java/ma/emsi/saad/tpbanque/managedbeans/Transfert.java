/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.saad.tpbanque.managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import ma.emsi.saad.tpbanque.ejb.GestionnaireCompte;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    private Long idsrc;
    private Long iddest;
    private CompteBancaire src;
    private CompteBancaire dest;
    private int mnt;
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public Transfert() {
    }

    public String transactionBancaire() {
        src = gestionnaireCompte.findById(idsrc);
        dest = gestionnaireCompte.findById(iddest);
        if (src != null && dest != null && src.getSolde() >= mnt) {
            gestionnaireCompte.transfert(src, dest, mnt);
            Util.addFlashInfoMessage("Transfert de " + src.getNom() + " vers "
                    + dest.getNom()
                    + " pour un montant de " + mnt + " correctement effectué");
            return "listeComptes?faces-redirect=true";
        }
        if (src == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
        }
        if (dest == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
        }
        if (src.getSolde() <= mnt) {
            Util.messageErreur("Montant insuffisant !", "Montant insuffisant  !", "form:montant");
        }
        return null;
    }
    
    
    public String check() {
        src = gestionnaireCompte.findById(idsrc);
        dest = gestionnaireCompte.findById(iddest);
       
        if (src == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
        }else
        {
            Util.messageErreur("compte de M/Mme " + src.getNom() +"avec un solde de " + src.getSolde(), "compte existe !", "form:source");
        }
        if (dest == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
        }else{
            Util.messageErreur("compte de M/Mme " + dest.getNom() +"avec un solde de " + dest.getSolde(), "compte existe !", "form:destination");
        }
        if (src != null && src.getSolde() <= mnt){
            Util.messageErreur("Montant insuffisant le maximum et "+src.getSolde()+" !", "Montant insuffisant  !", "form:montant");
        }else {
             Util.messageErreur("Montant est suffisant por cette transaction !", "Montant suffisant  !", "form:montant");
        }
        return null;

    }

    public Long getIdsrc() {
        return idsrc;
    }

    public void setIdsrc(Long idsrc) {
        this.idsrc = idsrc;
    }

    public Long getIddest() {
        return iddest;
    }

    public void setIddest(Long iddest) {
        this.iddest = iddest;
    }

    public CompteBancaire getSrc() {
        return src;
    }

    public void setSrc(CompteBancaire src) {
        this.src = src;
    }

    public CompteBancaire getDest() {
        return dest;
    }

    public void setDest(CompteBancaire dest) {
        this.dest = dest;
    }

    public int getMnt() {
        return mnt;
    }

    public void setMnt(int mnt) {
        this.mnt = mnt;
    }

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

}
