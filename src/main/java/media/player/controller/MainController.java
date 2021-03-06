package media.player.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("isAdmin", "admin".equals(profile));
        return "index";
    }
}
