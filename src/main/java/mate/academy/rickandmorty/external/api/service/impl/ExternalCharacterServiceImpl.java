package mate.academy.rickandmorty.external.api.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterResponseDto;
import mate.academy.rickandmorty.external.api.service.ExternalCharacterService;
import mate.academy.rickandmorty.mapping.CharacterMapper;
import mate.academy.rickandmorty.models.Character;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalCharacterServiceImpl implements ExternalCharacterService {
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Override
    public void saveOrUpdate(CharacterResponseDto characterResponseDto) {
        Optional<Character> characterOptional = characterRepository
                .findByExternalId(characterResponseDto.externalId())
                .stream()
                .findFirst();

        if (characterOptional.isEmpty()) {
            characterRepository.save(
                    characterMapper.convertFromResponseDto(characterResponseDto));
        } else {
            Character character = characterOptional.get();

            if (isEqual(characterResponseDto, character)) {
                return;
            }

            characterMapper.updateCharacterFromResponseDto(characterResponseDto, character);
            characterRepository.save(character);
        }
    }

    private boolean isEqual(CharacterResponseDto characterResponseDto, Character character) {
        return characterResponseDto.name().equals(character.getName())
                && characterResponseDto.gender().equals(character.getGender())
                && characterResponseDto.status().equals(character.getStatus());
    }
}
