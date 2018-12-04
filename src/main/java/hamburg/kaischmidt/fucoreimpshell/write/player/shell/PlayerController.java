package hamburg.kaischmidt.fucoreimpshell.write.player.shell;

import hamburg.kaischmidt.fucoreimpshell.write.player.core.PlayerCreatedCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PlayerController {

    @Value("${fucoreimpshell.customer}")
    private String CUSTOMER = "";

    private PlayerCreatedCommandHandler handler;

    public PlayerController(PlayerCreatedCommandHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/command/create-player")
    public RedirectView createPlayer(@RequestParam(value = "Spielername") String playerName, RedirectAttributes attributes) {

        var command = new PlayerCreatedCommand(playerName);
        handler.handle(command);

        attributes.addAttribute("newPlayer", playerName);
        return new RedirectView("/");
    }
}