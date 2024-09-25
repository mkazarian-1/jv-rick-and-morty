package mate.academy.rickandmorty;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.external.api.service.DbSynchronizationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
    private static final String RICK_AND_MORTY_API_CHARACTER_URL = "https://rickandmortyapi.com/api/character";

    private final DbSynchronizationService dbSynchronizationService;

    @Override
    public void run(String... args) throws Exception {
        dbSynchronizationService.synchronize(RICK_AND_MORTY_API_CHARACTER_URL);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
