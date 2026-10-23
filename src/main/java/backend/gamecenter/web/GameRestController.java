package backend.gamecenter.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;

@RestController
public class GameRestController {

    private final GameRepository gameRepository;

    public GameRestController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/api/games")
    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/api/games/{id}")
    public Optional<Game> findById(@PathVariable("id") Long id) {
        return gameRepository.findById(id);
    }

}
