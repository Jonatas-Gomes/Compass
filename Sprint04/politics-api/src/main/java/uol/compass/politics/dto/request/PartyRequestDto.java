package uol.compass.politics.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.politics.enums.Ideology;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PartyRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String Sigla;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Ideology ideology;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dateFoundation;
}
