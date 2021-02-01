package com.footiestats.DogFoodMaker.Controller;

import com.footiestats.DogFoodMaker.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class DogFoodController {
    private Producer producer;

    @Autowired
    public DogFoodController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @GetMapping (value = "/publish")
    public String getHello (){
        return "hello";
    }


}