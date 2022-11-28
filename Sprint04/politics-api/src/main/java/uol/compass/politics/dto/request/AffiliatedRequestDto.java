package uol.compass.politics.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.politics.enums.Gender;
import uol.compass.politics.enums.PoliticalOffice;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AffiliatedRequestDto {
    @NotBlank
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PoliticalOffice politicalOffice;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
