package mate.academy.rickandmorty.external.api.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterFullResponseDto;
import mate.academy.rickandmorty.external.api.service.DbSynchronizationService;
import mate.academy.rickandmorty.external.api.service.ExternalCharacterService;
import mate.academy.rickandmorty.external.api.service.GetClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbSynchronizationServiceImpl implements DbSynchronizationService {
    private final GetClient<CharacterFullResponseDto> getClient;
    private final ExternalCharacterService externalCharacterService;

    @Override
    public void synchronize(String url) {
        CharacterFullResponseDto fullResponseDto = getClient.getDtoFromApi(url);

        if (fullResponseDto.getResults().isEmpty()) {
            return;
        }

        while (true) {
            fullResponseDto.getResults().forEach(externalCharacterService::saveOrUpdate);

            if (fullResponseDto.getInfo().next() == null) {
                break;
            }

            fullResponseDto = getClient.getDtoFromApi(fullResponseDto.getInfo().next());
        }

    }
}
