package uol.compass.politics.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import uol.compass.politics.enums.Gender;
import uol.compass.politics.enums.PoliticalOffice;

import java.time.LocalDate;
@Data
public class AffiliatedResponseDto {
    private Long id;
    private String name;
    private PoliticalOffice politicalOffice;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private String associatedParty = "nenhum";


}
