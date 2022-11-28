package uol.compass.politics.dto.request;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociationPartyAffiliatedRequestDto {
    private Long idAffiliated;
    private Long idParty;
}
