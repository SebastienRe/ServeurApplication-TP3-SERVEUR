package bean_entity;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateful;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.EntityManager;

@Stateful // version stateless dans un autre commit (tag A-Stateless) 
          //et A-Stateful pour voir les différences entre les deux)
public class GestionLivre implements IGestionLivre { // bean
    @PersistenceContext(unitName="monUnite", type = PersistenceContextType.EXTENDED)
    protected EntityManager em;
    Emprunteur emp;

    @Resource(name="nbEmpruntMax")
    int nbEmpruntMax;

    public void creerSession(int numemp) throws EmprunteurNotFound {
        emp = em.find(Emprunteur.class, numemp);
        if (emp == null) throw new EmprunteurNotFound();
    }

    public void nouveauLivre(String isbn, String titre) {
        LivreEmp l = new LivreEmp(isbn, titre);
        em.persist(l);

        System.out.println("Livre enregistré: " + l);
    }

    public void supprimerLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);

        int empnum = l.getEmprunteur();
        Emprunteur emp = em.find(Emprunteur.class, empnum);
        emp.rendreLivre();

        em.remove(l);
        System.out.println("Livre supprimé: " + l);
    }

    public void emprunterLivre(String isbn) throws NbMaxEmpruntsAtteintException, LivreDejaEmprunte {
        LivreEmp l = em.find(LivreEmp.class, isbn);
        if (l.getEmprunteur() != 0) throw new LivreDejaEmprunte();

        l.setEmprunteur(emp.getNumemp());
        emp.emprunterLivre(nbEmpruntMax);

        System.out.println("Livre emprunté: " + l);
    }

    public void rendreLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);

        l.setEmprunteur(0);
        emp.rendreLivre();

        System.out.println("Livre rendu: " + l);
    }

    public void nouveauEmprunteur(int numemp, String nom) {
        Emprunteur emp = new Emprunteur(numemp, nom);
        em.persist(emp);

        System.out.println("Emprunteur enregistré: " + emp);
    }
}
