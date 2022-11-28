package uol.compass.politics.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.politics.dto.request.PartyRequestDto;
import uol.compass.politics.dto.response.PageablePartyResponseDto;
import uol.compass.politics.dto.response.PartyListAffiliatesResponseDto;
import uol.compass.politics.dto.response.PartyResponseDto;
import uol.compass.politics.enums.Ideology;
import uol.compass.politics.services.PartyService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/politics/parties")
@RequiredArgsConstructor
public class PartyController {
    private final PartyService partyService;
    @PostMapping
    public ResponseEntity <PartyResponseDto> create(@RequestBody @Valid PartyRequestDto partyRequest){
       PartyResponseDto partyResponse = partyService.create(partyRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(partyResponse);
    }
    @GetMapping
    public ResponseEntity<PageablePartyResponseDto> listAll(@RequestParam(required = false) Ideology ideology, Pageable pageable){
        PageablePartyResponseDto parties2 = partyService.listAll(ideology, pageable);
        //List<PartyResponseDto> parties = partyService.listAll(ideology, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(parties2);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartyResponseDto> findById(@PathVariable Long id){
        PartyResponseDto party = partyService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(party);
    }
    @GetMapping("/{id}/affiliates")
    public ResponseEntity<List<PartyListAffiliatesResponseDto>> listAllAffiliates(@PathVariable Long id){
        List<PartyListAffiliatesResponseDto> partyAffiliates = partyService.listAllAffiliates(id);
        return ResponseEntity.status(HttpStatus.OK).body(partyAffiliates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        partyService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartyResponseDto> update(@PathVariable Long id, @RequestBody @Valid PartyRequestDto partyRequest){
        PartyResponseDto partyUpdate = partyService.update(id, partyRequest);
        return ResponseEntity.status(HttpStatus.OK).body(partyUpdate);
    }

}
