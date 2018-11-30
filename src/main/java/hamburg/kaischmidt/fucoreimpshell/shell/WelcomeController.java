package hamburg.kaischmidt.fucoreimpshell.shell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Value("${fucoreimpshell.customer}")
    private String CUSTOMER = "";

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("customer", CUSTOMER);
        return "welcome";
    }
}
