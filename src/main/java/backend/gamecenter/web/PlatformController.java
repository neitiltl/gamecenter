package backend.gamecenter.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import backend.gamecenter.domain.Platform;
import backend.gamecenter.domain.PlatformRepository;
import jakarta.validation.Valid;

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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createPlatform(Model model) {
        model.addAttribute("platform", new Platform());
        return "createplatform";
    }

    @PostMapping("/saveplatform")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String savePlatform(@Valid @ModelAttribute("platform") Platform platform, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createplatform";
        }
        platformRepository.save(platform);
        return "redirect:/platformlist";
    }

}
