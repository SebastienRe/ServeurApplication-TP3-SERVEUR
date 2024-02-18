package bean_entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="auteur")
//create table auteur (num smallint not null primary key, nom char(20)); 
public class Auteur {

    @Id
    private int num;
    private String nom;

    @OneToMany(mappedBy = "auteur_num")
    private List<Livre> livres;

    public Auteur() {
    }

    public Auteur(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public List<Livre> getLivres() {
        return livres;
    }
}
