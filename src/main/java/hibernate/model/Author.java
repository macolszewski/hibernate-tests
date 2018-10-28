package hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "author_new")
public class Author {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column( name = "author_id")
    private String id;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "name",column = @Column(name="imie")),
            @AttributeOverride(name = "surname",column = @Column(name="nazwisko"))})
    private Human human;

    @Column(name = "gatunek")
    private String gatunek;

    @Column(name = "psudonim")
    private String pseudonim_literacki;

    @Column(name = "nagrody")
    private String nagrody;


    public Author() {
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getPseudonim_literacki() {
        return pseudonim_literacki;
    }

    public void setPseudonim_literacki(String pseudonim_literacki) {
        this.pseudonim_literacki = pseudonim_literacki;
    }

    public String getNagrody() {
        return nagrody;
    }

    public void setNagrody(String nagrody) {
        this.nagrody = nagrody;
    }
}