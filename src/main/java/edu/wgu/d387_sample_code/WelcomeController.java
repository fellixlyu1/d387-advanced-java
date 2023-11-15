package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/")
public class WelcomeController {
    @GetMapping("/welcome")
    public String[] getWelcomeMessage() {

        EnglishWelcomeImpl englishWelcome = new EnglishWelcomeImpl();
        Thread englishThread = new Thread(englishWelcome);

        FrenchWelcomeImpl frenchWelcome = new FrenchWelcomeImpl();
        Thread frenchThread = new Thread(frenchWelcome);

        englishThread.start();
        frenchThread.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message englishMessage = new Message(englishWelcome.getMessage());

        Message frenchMessage = new Message(frenchWelcome.getMessage());

        String[] message = new String[]{englishMessage.getGreeting(), frenchMessage.getGreeting()};

        return message;
    }
}
