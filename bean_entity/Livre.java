package bean_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//create table livre_tp32( isbn char(4) not null primary key,titre char(20),
//  auteur_num smallint references auteur(num) ); 
@Table(name="livre_tp32")
public class Livre {
    @Id
    private String isbn;
    private String titre;

    @OneToOne(mappedBy = "livre")
    private DetailsLivre details;

    @ManyToOne
    @JoinColumn(name = "auteur_num", referencedColumnName = "num")
    private Auteur auteur_num;

    public Livre() {
    }

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }
    
    public DetailsLivre getDetails(){
        return this.details;
    }

    public void setAuteur(Auteur auteur_num){
        this.auteur_num = auteur_num;
    }

    public Auteur getAuteur(){
        return this.auteur_num;
    }
}