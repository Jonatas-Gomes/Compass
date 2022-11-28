package uol.compass.politics.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.politics.dto.request.AffiliatedRequestDto;
import uol.compass.politics.dto.request.AssociationPartyAffiliatedRequestDto;
import uol.compass.politics.dto.response.AffiliatedResponseDto;
import uol.compass.politics.dto.response.CreateAssocationResponseDto;
import uol.compass.politics.dto.response.PageableAffiliatedResponseDto;
import uol.compass.politics.entity.AffiliatedEntity;
import uol.compass.politics.entity.PartyEntity;
import uol.compass.politics.enums.PoliticalOffice;
import uol.compass.politics.exceptions.EntityNotFoundException;
import uol.compass.politics.repository.AffiliatedRepository;
import uol.compass.politics.repository.PartyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AffiliatedService {
    private final AffiliatedRepository affiliatedRepository;
    private final ModelMapper modelMapper;

    private final PartyRepository partyRepository;

    public AffiliatedResponseDto create(AffiliatedRequestDto affliatedRequest){
        AffiliatedEntity createAffiliatedEntity = modelMapper.map(affliatedRequest,AffiliatedEntity.class);
        AffiliatedEntity affiliatedEntityCreated = affiliatedRepository.save(createAffiliatedEntity);
        return modelMapper.map(affiliatedEntityCreated, AffiliatedResponseDto.class);
    }

    public PageableAffiliatedResponseDto listAll(PoliticalOffice office, Pageable pageable) {
        Page<AffiliatedEntity> page = office == null?
                affiliatedRepository.findAll(pageable):
                affiliatedRepository.findByPoliticalOffice(office, pageable);
        List<AffiliatedEntity> affiliatedEntities= page.getContent();
        List<AffiliatedResponseDto>affiliatesListDto = modelMapper.map(affiliatedEntities, new TypeToken<List<AffiliatedResponseDto>>(){}.getType());
        return PageableAffiliatedResponseDto.builder()
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .affiliates(affiliatesListDto)
                .build();
    }

    public AffiliatedResponseDto findById(Long id) {
        Optional<AffiliatedEntity> affiliated = affiliatedRepository.findById(id);
        return modelMapper.map(affiliated, AffiliatedResponseDto.class);
    }

    public void delete(Long id) {
        verifyAffiliatedExists(id);
        affiliatedRepository.deleteById(id);
    }

    public AffiliatedResponseDto update(Long id, AffiliatedRequestDto affiliatedRequest) {
        verifyAffiliatedExists(id);
        AffiliatedEntity affiliatedUpdate = affiliatedRepository.getReferenceById(id);
        affiliatedUpdate.setName(affiliatedRequest.getName());
        affiliatedUpdate.setPoliticalOffice(affiliatedRequest.getPoliticalOffice());
        affiliatedUpdate.setBirthDate(affiliatedRequest.getBirthDate());
        affiliatedUpdate.setGender(affiliatedRequest.getGender());
        affiliatedRepository.save(affiliatedUpdate);

        return modelMapper.map(affiliatedUpdate, AffiliatedResponseDto.class);
    }


    @Transactional
    public AffiliatedResponseDto createAssociation(AssociationPartyAffiliatedRequestDto associationRequest) {
        verifyAffiliatedExists(associationRequest.getIdAffiliated());
        verifyPartyExists(associationRequest.getIdParty());
        PartyEntity partyToAssociation = partyRepository.getReferenceById(associationRequest.getIdParty());
        AffiliatedEntity affiliatedToAssociation = affiliatedRepository.getReferenceById(associationRequest.getIdAffiliated());
        if(affiliatedToAssociation.getAssociatedParty() != null){
            CreateAssocationResponseDto responseDto = modelMapper.map(affiliatedToAssociation, CreateAssocationResponseDto.class);
            responseDto.setAssociatedParty(affiliatedToAssociation.getAssociatedParty().getName());
            responseDto.setMessage("Afiliado já associado a um partido");
            return responseDto;
        }
        partyToAssociation.addAffiliated(affiliatedToAssociation);
        affiliatedToAssociation.setAssociatedParty(partyToAssociation);
        partyRepository.save(partyToAssociation);
        affiliatedRepository.save(affiliatedToAssociation);
        AffiliatedResponseDto affiliatedResponseDto = modelMapper.map(affiliatedToAssociation, AffiliatedResponseDto.class);
        affiliatedResponseDto.setAssociatedParty(affiliatedToAssociation.getAssociatedParty().getName());
        return affiliatedResponseDto;
    }

    public AffiliatedResponseDto deleteAssociation(Long id, Long idParty) {
        verifyPartyExists(idParty);
        verifyAffiliatedExists(id);
        PartyEntity partyToDeleteAssociation = partyRepository.getReferenceById(idParty);
        AffiliatedEntity affiliatedToDeleteAssociation = affiliatedRepository.getReferenceById(id);
        PartyEntity partyEntity = null;
        affiliatedToDeleteAssociation.setAssociatedParty(partyEntity);
        partyToDeleteAssociation.deleteAffiliated(affiliatedToDeleteAssociation);
        affiliatedRepository.save(affiliatedToDeleteAssociation);
        partyRepository.save(partyToDeleteAssociation);
        return modelMapper.map(affiliatedToDeleteAssociation, AffiliatedResponseDto.class);
    }
    private void verifyAffiliatedExists(Long id) {
        Optional<AffiliatedEntity> affiliated = affiliatedRepository.findById(id);
        if (!affiliated.isPresent()){
            throw new EntityNotFoundException();
        }
    }
    private void verifyPartyExists(Long id){
        Optional<PartyEntity> party = partyRepository.findById(id);
        if (!party.isPresent()){
            throw new EntityNotFoundException();
        }
    }

}
