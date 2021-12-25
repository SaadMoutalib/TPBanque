/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.saad.tpbanque.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import ma.emsi.saad.tpbanque.ejb.GestionnaireCompte;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;
import ma.emsi.saad.tpbanque.entities.OperationBancaire;

/**
 *
 * @author saad-
 */
@Named(value = "historique")
@RequestScoped
public class Historique {
    List<OperationBancaire> operation;
    private Long id;
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    public Historique() {}
    public List<OperationBancaire> getOprations(){
        CompteBancaire c = gestionnaireCompte.findById(id);
        if(c!=null){
            operation =c.getOperations();
            return operation;
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
