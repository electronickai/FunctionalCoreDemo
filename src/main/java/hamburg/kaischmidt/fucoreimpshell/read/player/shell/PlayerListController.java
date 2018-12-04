package hamburg.kaischmidt.fucoreimpshell.read.player.shell;

import hamburg.kaischmidt.fucoreimpshell.read.player.core.PlayerSorter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayerListController {

    private PlayerListProjection playerList;
    private PlayerSorter sorter;

    public PlayerListController(PlayerListProjection playerList, PlayerSorter sorter) {
        this.playerList = playerList;
        this.sorter = sorter;
    }

    @GetMapping("/read/player-list")
    public String showPlayerList(Model model) {
        List<String> sortedPlayers = sorter.sort(playerList.getPlayers());
        model.addAttribute("players", sortedPlayers);
        return "player-list";
    }
}
