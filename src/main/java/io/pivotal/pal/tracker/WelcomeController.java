package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final String welcome_msg;

    @Autowired
    public WelcomeController(@Value("${welcome_message}") String welcome_msg){
        this.welcome_msg = welcome_msg;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcome_msg;
    }


}
