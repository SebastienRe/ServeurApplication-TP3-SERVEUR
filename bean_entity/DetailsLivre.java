package bean_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="details_livre")
public class DetailsLivre {

    @Id
    String isbn;
    int nbpages;
    
    @Column(name = "annee_parution")
    int anneeParution ;

    @OneToOne
    @JoinColumn(name = "isbn", 
                referencedColumnName = "isbn", 
                insertable = false, 
                updatable = false)
    Livre livre;

    public DetailsLivre() {
    }

    public DetailsLivre(String isbn, int nbpages, int anneeParution) {
        this.isbn = isbn;
        this.nbpages = nbpages;
        this.anneeParution = anneeParution;
    }

    public int getNbPages() {
        return nbpages;
    }

    
}
