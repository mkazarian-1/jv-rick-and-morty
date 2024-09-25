package mate.academy.rickandmorty.dto.external;

import java.util.List;
import lombok.Data;

@Data
public class CharacterFullResponseDto {
    private CharacterMetadataDto info;
    private List<CharacterResponseDto> results;
}
