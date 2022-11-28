package uol.compass.politics.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.politics.entity.AffiliatedEntity;
import uol.compass.politics.enums.PoliticalOffice;

public interface AffiliatedRepository extends JpaRepository<AffiliatedEntity, Long> {

    Page<AffiliatedEntity> findByPoliticalOffice(PoliticalOffice office, Pageable pageable);
}
