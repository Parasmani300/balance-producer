package com.github.parasmani300.bankbalance.producer;

//import com.github.parasmani300.avroformatexample.dto.SampleClass;
import com.github.parasmani300.bankbalance.avro.SampleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

    private static  final String TOPIC = "sample-balance";

    @Autowired
    KafkaTemplate<String,SampleClass> kafkaTemplate;

    public boolean produceMessage(SampleClass sampleClass)
    {
        try{
            final ListenableFuture<SendResult<String, SampleClass>> send = this.kafkaTemplate.send(TOPIC, String.valueOf(sampleClass.getName()), sampleClass);
            send.addCallback(
                    new ListenableFutureCallback<SendResult<String, SampleClass>>() {
                        @Override
                        public void onFailure(Throwable ex) {
                            System.out.println("Message failed to publish");
                        }

                        @Override
                        public void onSuccess(SendResult<String, SampleClass> result) {
                            System.out.println(result.getProducerRecord().value().getClass());
                        }
                    }
            );
            return  true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
