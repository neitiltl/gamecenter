package backend.gamecenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;
import backend.gamecenter.domain.PlatformRepository;
import jakarta.validation.Valid;

@Controller
public class GameController {
    private final GameRepository gameRepository;
    private final PlatformRepository platformRepository;

    public GameController(GameRepository gameRepository, PlatformRepository platformRepository) {
        this.gameRepository = gameRepository;
        this.platformRepository = platformRepository;
    }

    @GetMapping({ "/", "/index" })
    public String returnIndex(Model model) {
        return "index";
    }

    @GetMapping("/newgame")
    public String returnGameForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("platforms", platformRepository.findAll());
        return "gameform";
    }

    @PostMapping("/savegame")
    public String saveGame(Game game) {
        gameRepository.save(game);
        return "showgame";
    }

    @GetMapping("/gamelist")
    public String showAllGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "gamelist";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(
            @PathVariable("id") Long id, Model model) {
        gameRepository.deleteById(id);
        return "redirect:../gamelist";
    }

    @GetMapping("/edit/{id}")
    public String editGame(@PathVariable("id") Long id, Model model) {
        model.addAttribute("game", gameRepository.findById(id));
        model.addAttribute("platforms", platformRepository.findAll());
        return "editgameform";
    }

}
