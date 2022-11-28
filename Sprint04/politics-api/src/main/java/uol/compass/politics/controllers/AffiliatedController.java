package uol.compass.politics.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.politics.dto.request.AffiliatedRequestDto;
import uol.compass.politics.dto.request.AssociationPartyAffiliatedRequestDto;
import uol.compass.politics.dto.response.AffiliatedResponseDto;
import uol.compass.politics.dto.response.PageableAffiliatedResponseDto;
import uol.compass.politics.enums.PoliticalOffice;
import uol.compass.politics.services.AffiliatedService;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/politics/affiliates")
@RequiredArgsConstructor
public class AffiliatedController {
    private final AffiliatedService affiliatedService;

    @PostMapping
    public ResponseEntity<AffiliatedResponseDto> create(@RequestBody @Valid AffiliatedRequestDto affiliatedRequest){
        AffiliatedResponseDto affiliatedResponse = affiliatedService.create(affiliatedRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(affiliatedResponse);
    }

    @GetMapping
    public ResponseEntity<PageableAffiliatedResponseDto> listAll(@RequestParam(required = false) PoliticalOffice office, Pageable pageable){
        PageableAffiliatedResponseDto affiliates = affiliatedService.listAll(office, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(affiliates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffiliatedResponseDto> findById(@PathVariable Long id){
        AffiliatedResponseDto affiliated = affiliatedService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(affiliated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        affiliatedService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffiliatedResponseDto> update(@PathVariable Long id, @RequestBody @Valid AffiliatedRequestDto affiliatedRequest){
        AffiliatedResponseDto affiliatedUpdate = affiliatedService.update(id, affiliatedRequest);
        return ResponseEntity.status(HttpStatus.OK).body(affiliatedUpdate);
    }
    @Transactional
    @PutMapping("/parties")
    public ResponseEntity<AffiliatedResponseDto> createAssociation(@RequestBody @Valid AssociationPartyAffiliatedRequestDto associationRequest){
        AffiliatedResponseDto affiliatedAssociation = affiliatedService.createAssociation(associationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(affiliatedAssociation);
    }
    @PutMapping("/{id}/parties/{idParty}")
    public ResponseEntity<AffiliatedResponseDto> deleteAssociation(@PathVariable Long id, @PathVariable Long idParty){
        AffiliatedResponseDto affiliatedToDeleteAssociation = affiliatedService.deleteAssociation(id, idParty);
        return ResponseEntity.status(HttpStatus.OK).body(affiliatedToDeleteAssociation);
    }
}
