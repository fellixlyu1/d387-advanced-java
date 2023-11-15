package edu.wgu.d387_sample_code;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnglishWelcomeImpl implements Runnable {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("welcome", new Locale("en", "US"));
        this.message = bundle.getString("welcomeMessage");
    }
}
