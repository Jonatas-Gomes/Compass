package uol.compass.politics.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.politics.dto.request.PartyRequestDto;
import uol.compass.politics.dto.response.PageablePartyResponseDto;
import uol.compass.politics.dto.response.PartyListAffiliatesResponseDto;
import uol.compass.politics.dto.response.PartyResponseDto;
import uol.compass.politics.entity.AffiliatedEntity;
import uol.compass.politics.entity.PartyEntity;
import uol.compass.politics.enums.Ideology;
import uol.compass.politics.exceptions.EntityNotFoundException;
import uol.compass.politics.repository.PartyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyService {
    private  final PartyRepository partyRepository;
    private final ModelMapper modelMapper;
    public PartyResponseDto create(PartyRequestDto partyRequest){
        PartyEntity createPartyEntity = modelMapper.map(partyRequest,PartyEntity.class);
        PartyEntity partyEntityCreated = partyRepository.save(createPartyEntity);
        return modelMapper.map(partyEntityCreated, PartyResponseDto.class);
    }

    public PageablePartyResponseDto listAll(Ideology ideology, Pageable pageable) {
        Page<PartyEntity> page = ideology == null?
                partyRepository.findAll(pageable):
                partyRepository.findByIdeology(ideology, pageable);
        List<PartyEntity> partyEntities= page.getContent();
        List<PartyResponseDto>partiesListDto = modelMapper.map(partyEntities, new TypeToken<List<PartyResponseDto>>(){}.getType());
        return PageablePartyResponseDto.builder()
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .parties(partiesListDto)
                .build();
    }

    public PartyResponseDto findById(Long id) {
        Optional<PartyEntity> party = partyRepository.findById(id);
        if(party.isPresent()){
            return modelMapper.map(party, PartyResponseDto.class);
        }
        throw new EntityNotFoundException();
    }

    public void delete(Long id) {
        verifyPartyExists(id);
        partyRepository.deleteById(id);
    }

    public PartyResponseDto update(Long id, PartyRequestDto partyRequest) {
        verifyPartyExists(id);
        Optional<PartyEntity> partyEntity = partyRepository.findById(id);
        PartyEntity partyUpdate = modelMapper.map(partyEntity, PartyEntity.class);
        partyUpdate.setName(partyRequest.getName());
        partyUpdate.setSigla(partyRequest.getSigla());
        partyUpdate.setIdeology(partyRequest.getIdeology());
        partyUpdate.setDateFoundation(partyRequest.getDateFoundation());
        partyRepository.save(partyUpdate);

        return modelMapper.map(partyUpdate, PartyResponseDto.class);
    }

    public List<PartyListAffiliatesResponseDto> listAllAffiliates(Long id) {
        verifyPartyExists(id);
        PartyEntity partyEntity = partyRepository.getReferenceById(id);
        List< AffiliatedEntity> affiliatesList = partyEntity.listAffiliates();
        List<PartyListAffiliatesResponseDto>partiesListDto = modelMapper.map(affiliatesList, new TypeToken<List<PartyListAffiliatesResponseDto>>(){}.getType());
        return partiesListDto;
    }

    private void verifyPartyExists(Long id){
        Optional<PartyEntity> party = partyRepository.findById(id);
        if (!party.isPresent()){
            throw new EntityNotFoundException();
        }
    }
}
