/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ma.emsi.saad.tpbanque.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.emsi.saad.tpbanque.entities.CompteBancaire;

/**
 *
 * @author saad-
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "naruto$@1996", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext
    private EntityManager em;

    public Long nbComptes() {
        return (Long) em.createQuery("select count(c) from CompteBancaire c").getSingleResult();
    }

    public List<CompteBancaire> getAllComptes() {
        Query query = em.createNamedQuery("CompteBancaire.findAll");
        return query.getResultList();
    }

    public CompteBancaire getCompteBancaire(Long idcmpt) {
        return em.find(CompteBancaire.class, idcmpt);
    }

    public CompteBancaire update(CompteBancaire cmptB) {
        return em.merge(cmptB);
    }

    public CompteBancaire findById(Long id) {
        return em.find(CompteBancaire.class, id);
    }

    public void deposer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.deposer(montant);
        update(compteBancaire);
    }

    public void retirer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.retirer(montant);
        update(compteBancaire);
    }

    public void supprimer(CompteBancaire compte) {
        em.remove(em.merge(compte));
    }

    public void transfert(CompteBancaire src, CompteBancaire dest, int mnt) {
        src.retirer(mnt);
        dest.deposer(mnt);
        update(src);
        update(dest);
    }

    public void creerCompte(CompteBancaire c) {
        try {
            em.persist(c);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
