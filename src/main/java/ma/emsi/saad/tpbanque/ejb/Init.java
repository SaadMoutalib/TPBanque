/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ma.emsi.saad.tpbanque.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@Singleton
@Startup
public class Init {
    @Inject
    private GestionnaireCompte gc;

    @PostConstruct
    public void initialize() {
        if (gc.nbComptes() == 0) {
            gc.creerCompte(new CompteBancaire("John Lennon", 150000));
            gc.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gc.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gc.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
}
