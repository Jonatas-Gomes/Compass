package uol.compass.politics.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uol.compass.politics.enums.Gender;
import uol.compass.politics.enums.PoliticalOffice;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AffiliatedEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PoliticalOffice politicalOffice;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private PartyEntity associatedParty;

    public AffiliatedEntity(String name, PoliticalOffice politicalOffice, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.politicalOffice = politicalOffice;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
