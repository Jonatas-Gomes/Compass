package uol.compass.politics.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import uol.compass.politics.enums.Ideology;

import java.time.LocalDate;
@Data
public class PartyResponseDto {
    private Long id;
    private String name;
    private String Sigla;
    private Ideology ideology;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFoundation;
}
