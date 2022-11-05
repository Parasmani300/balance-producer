package com.github.parasmani300.bankbalance.controller;

import com.github.parasmani300.bankbalance.dto.ControllerMessage;
import com.github.parasmani300.bankbalance.dto.SampleDto;
import com.github.parasmani300.bankbalance.service.MessageCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageCreator messageCreator;

    @PostMapping("/publish")
    public ControllerMessage sendMessage(@RequestBody  SampleDto sampleDto)
    {
        return  this.messageCreator.createMessage(sampleDto);
    }
}
