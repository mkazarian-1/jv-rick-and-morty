package mate.academy.rickandmorty.external.api.service;

import mate.academy.rickandmorty.dto.external.CharacterResponseDto;

public interface ExternalCharacterService {
    void saveOrUpdate(CharacterResponseDto characterResponseDto);
}
