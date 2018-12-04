package hamburg.kaischmidt.fucoreimpshell.write.shell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WelcomeController {

    @Value("${fucoreimpshell.customer}")
    private String CUSTOMER = "";

    @GetMapping("/")
    public String welcome(@ModelAttribute("newPlayer") String newPlayer, Model model) {
        model.addAttribute("customer", CUSTOMER);
        return "welcome";
    }
}
