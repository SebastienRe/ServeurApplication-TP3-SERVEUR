package bean_entity;

import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless
public class GestionLivre implements GestionLivreInterface { // bean
    @PersistenceContext(unitName="monUnite")
    protected EntityManager em;

    public int getNbPages(String isbn) {
        Livre l = em.find(Livre.class, isbn);
        return l.getDetails().getNbPages();
    }
    
}

