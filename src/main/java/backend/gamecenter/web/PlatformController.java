package backend.gamecenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import backend.gamecenter.domain.Platform;
import backend.gamecenter.domain.PlatformRepository;

@Controller
public class PlatformController {
    private final PlatformRepository platformRepository;

    public PlatformController(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @GetMapping("/platformlist")
    public String showPlatformList(Model model) {
        model.addAttribute("platforms", platformRepository.findAll());
        return "platformlist";
    }

    @GetMapping("/createplatform")
    public String createPlatform(Model model) {
        model.addAttribute("platform", new Platform());
        return "createplatform";
    }

    @PostMapping("/saveplatform")
    public String savePlatform(Platform platform) {
        platformRepository.save(platform);
        return "redirect:/platformlist";
    }

}
