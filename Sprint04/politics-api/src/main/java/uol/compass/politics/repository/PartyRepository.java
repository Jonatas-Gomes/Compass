package uol.compass.politics.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.politics.entity.PartyEntity;
import uol.compass.politics.enums.Ideology;

import java.util.List;

public interface PartyRepository extends JpaRepository<PartyEntity, Long> {

    Page<PartyEntity> findByIdeology(Ideology ideology, Pageable page);

}
