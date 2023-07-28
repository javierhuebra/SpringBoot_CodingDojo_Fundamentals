package com.dojo.session;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gold/actions")
public class ControllerActionsNinjaGold {
    
    @PostMapping("/granja")
    public int granjaAction() {
        int goldEarned = getRandomRange(10, 20);
       
        return goldEarned;
    }

    private int getRandomRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}

