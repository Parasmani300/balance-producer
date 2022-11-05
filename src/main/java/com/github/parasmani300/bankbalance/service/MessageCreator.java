package com.github.parasmani300.bankbalance.service;

import com.github.parasmani300.bankbalance.avro.SampleClass;
import com.github.parasmani300.bankbalance.dto.ControllerMessage;
import com.github.parasmani300.bankbalance.dto.SampleDto;
import com.github.parasmani300.bankbalance.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCreator {

    @Autowired
    KafkaProducer kafkaProducer;

    public ControllerMessage createMessage(SampleDto sampleDto)
    {
        SampleClass sampleClass = new SampleClass(sampleDto.getName(),sampleDto.getBalance(),sampleDto.getTimestamp());

        if(kafkaProducer.produceMessage(sampleClass)){
                System.out.println("Message produced successfully" + sampleClass);
                 return new ControllerMessage("Message Produced successfully");
            }else {
                System.out.println("Issue producing message");
                return  new ControllerMessage("Issue producing message");
            }


    }
}
