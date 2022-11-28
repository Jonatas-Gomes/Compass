package uol.compass.politics.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageablePartyResponseDto {
    private Integer numberOfElements;

    private Long totalElements;

    private Integer totalPages;

    private List<PartyResponseDto> parties;



}
