package uol.compass.politics.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.politics.enums.Ideology;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PartyEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sigla;
    private Ideology ideology;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateFoundation;
    @OneToMany
    private  List<AffiliatedEntity> affiliated;

    public PartyEntity(String name, String sigla, Ideology ideology, LocalDate dateFoundation) {
        this.name = name;
        this.sigla = sigla;
        this.ideology = ideology;
        this.dateFoundation = dateFoundation;
    }

    public void addAffiliated(AffiliatedEntity affiliatedToSave){
        affiliated.add(affiliatedToSave);
    }

    public List<AffiliatedEntity> listAffiliates(){
        List<AffiliatedEntity> affiliatesList= new ArrayList<>();
        affiliated.forEach(actualAffiliated -> {
            affiliatesList.add(actualAffiliated);
        });
        return affiliatesList;
    }

    public void deleteAffiliated(AffiliatedEntity affiliatedToDeleteAssociation) {
        affiliated.remove(affiliatedToDeleteAssociation);
    }
}
