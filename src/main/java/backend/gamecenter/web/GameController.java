package backend.gamecenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;

@Controller
public class GameController {
    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping({ "/", "/index" })
    public String returnIndex(Model model) {
        return "index";
    }

    @GetMapping("/newgame")
    public String returnGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "gameform";
    }

    @PostMapping("/newgame")
    public String submitGame(Game game) {
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

    

}
