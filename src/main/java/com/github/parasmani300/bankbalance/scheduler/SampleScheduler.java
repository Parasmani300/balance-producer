//package com.github.parasmani300.bankbalance.scheduler;
//
////import com.github.parasmani300.avroformatexample.dto.SampleClass;
//import com.github.parasmani300.bankbalance.avro.SampleClass;
//import com.github.parasmani300.bankbalance.producer.KafkaProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@EnableScheduling
//public class SampleScheduler {
//
//    @Autowired
//    KafkaProducer kafkaProducer;
//
//    @Scheduled(fixedDelay = 3000)
//    public void secheduleWOrk()
//    {
//        List<SampleClass> list = new ArrayList<>();
//        SampleClass sampleClass = SampleClass.newBuilder()
//                                .setId(1)
//                                .setName("ABDD")
//                                 .setAge("123")
//                                    .build();
//        list.add(sampleClass);
//        list.forEach((element)->{
//            if(kafkaProducer.produceMessage(element)){
//                System.out.println("Message produced successfully" + element.getClass());
//            }else {
//                System.out.println("Issue producing message");
//            }
//        });
//
//    }
//}
