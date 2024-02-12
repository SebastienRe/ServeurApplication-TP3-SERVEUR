package bean_entity;

import jakarta.ejb.Remote;

@Remote
public interface IGestionLivre {

    public void creerSession(int numemp) throws EmprunteurNotFound;

    public void nouveauLivre(String isbn, String titre);
    public void supprimerLivre(String isbn);
    public void emprunterLivre(String isbn) throws NbMaxEmpruntsAtteintException, LivreDejaEmprunte;
    public void rendreLivre(String isbn);

    public void nouveauEmprunteur(int numemp, String nom);
}
