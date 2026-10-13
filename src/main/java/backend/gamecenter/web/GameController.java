package backend.gamecenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import backend.gamecenter.domain.Game;

@Controller
public class GameController {

    @GetMapping("/index")
    public String returnIndex(Model model) {
        return "index";
    }

    @GetMapping("/newgame")
    public String returnGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "gameform";
    }

    @PostMapping("/newgame")
    public String addGame(@ModelAttribute Game game, Model model) {
        model.addAttribute("game", game);
        return "gamelist";
    }

}
