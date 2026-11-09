package backend.gamecenter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;
import backend.gamecenter.domain.Platform;
import backend.gamecenter.domain.PlatformRepository;

@DataJpaTest
public class AddNewGameTest {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Test
    public void addNewGame() {
        Platform platform = new Platform("Android");

        platformRepository.save(platform);

        Game game = new Game("Game", "Publisher", 1999, "This is a fine game", platform);
        gameRepository.save(game);

        assertThat(game.getId()).isNotNull();

    }

}
