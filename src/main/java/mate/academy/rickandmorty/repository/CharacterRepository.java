package mate.academy.rickandmorty.repository;

import java.util.List;
import java.util.Optional;

import mate.academy.rickandmorty.models.Character;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CharacterRepository extends JpaRepository<Character,Long>,
        JpaSpecificationExecutor<Character> {
    Optional<Character> findFirstByExternalId(String externalId);

    List<Character> findByNameContaining(Pageable pageable, String name);

    @Query(value = "SELECT * FROM characters ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Character> findRandomCharacter();
}
