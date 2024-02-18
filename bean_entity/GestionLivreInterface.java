package bean_entity;

import jakarta.ejb.Remote;

@Remote
public interface GestionLivreInterface {
    public int getNbPages(String isbn);
    
}

