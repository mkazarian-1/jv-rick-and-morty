package mate.academy.rickandmorty.mapping;

import javax.annotation.processing.Generated;
import mate.academy.rickandmorty.dto.external.CharacterResponseDto;
import mate.academy.rickandmorty.dto.internal.CharacterDto;
import mate.academy.rickandmorty.models.Character;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T19:31:29+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public Character convertFromResponseDto(CharacterResponseDto characterResponseDto) {
        if ( characterResponseDto == null ) {
            return null;
        }

        Character character = new Character();

        character.setExternalId( characterResponseDto.externalId() );
        character.setName( characterResponseDto.name() );
        character.setStatus( characterResponseDto.status() );
        character.setGender( characterResponseDto.gender() );

        return character;
    }

    @Override
    public CharacterDto convertToDto(Character character) {
        if ( character == null ) {
            return null;
        }

        CharacterDto characterDto = new CharacterDto();

        characterDto.setId( character.getId() );
        characterDto.setExternalId( character.getExternalId() );
        characterDto.setName( character.getName() );
        characterDto.setStatus( character.getStatus() );
        characterDto.setGender( character.getGender() );

        return characterDto;
    }

    @Override
    public void updateCharacterFromResponseDto(CharacterResponseDto responseDto, Character character) {
        if ( responseDto == null ) {
            return;
        }

        character.setExternalId( responseDto.externalId() );
        character.setName( responseDto.name() );
        character.setStatus( responseDto.status() );
        character.setGender( responseDto.gender() );
    }
}
