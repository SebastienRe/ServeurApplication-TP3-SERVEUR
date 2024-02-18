package bean_entity;

import jakarta.ejb.Remote;

@Remote
public interface GestionLivreInterface {
    public int getNbPages(String isbn);
    public String getAuteur(String isbn) throws CannotGetNullAuthor;
    public void setAuteur(String isbn, int numAuteur);
    public void unsetAuteur(String isbn);
    public String getLivresAuthor(String isbn);
}

