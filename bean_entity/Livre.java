package bean_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="livre_tp31")
public class Livre {
    @Id
    private String isbn;
    private String titre;

    @OneToOne(mappedBy = "livre")
    DetailsLivre details;

    public Livre() {
    }

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }
    
    public DetailsLivre getDetails(){
        return this.details;
    }
}