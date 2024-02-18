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

    public String getAuteur(String isbn) throws CannotGetNullAuthor {
        Livre l = em.find(Livre.class, isbn);
        if (l.getAuteur() == null) throw new CannotGetNullAuthor();
        return l.getAuteur().getNom();
    }

    public void setAuteur(String isbn, int numAuteur) {
        Livre l = em.find(Livre.class, isbn);
        Auteur a = em.find(Auteur.class, numAuteur);
        l.setAuteur(a);
    }

    @Override
    public void unsetAuteur(String isbn) {
        Livre l = em.find(Livre.class, isbn);
        l.setAuteur(null);
    }
    
}

