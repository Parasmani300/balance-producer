package com.github.parasmani300.avroformatexample.config;

import com.github.parasmani300.avroformatexample.avro.SampleClass;
import com.github.parasmani300.avroformatexample.serializer.AvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class RootConfig {

    @Value("${spring.kafka.properties.bootstrap.servers}")
    String bootstrapServer;

    @Bean
    public ProducerFactory<String, SampleClass> producerFactory()
    {
        String topic = "sample-topic";
        String sasl_username = "Mani";
        String sasl_password = "12345678";
        String truststore_location = "C:\\pass\\kafka.truststore.jks";
        String truststore_password = "mk5od0WM";
        String keystore_location = "C:\\pass\\kafka.keystore.jks";
        String keystore_password = "mk5od0WM";

        String jaasTemplate = "org.apache.kafka.common.security.plain.PlainLoginModule   required username='QGW3TV47IPDQKKHY'   password='nvjo7LiGulN131E7to6ZsC4YJep4X9jlevfiMOKbt+6+bpyORGWo//lqeCjG2RqX';";
        String jaasConfig = jaasTemplate;

        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);

        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        props.put(SaslConfigs.SASL_JAAS_CONFIG, jaasConfig);

//        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, truststore_location);
//        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, truststore_password);
//        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, keystore_location);
//        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, keystore_password);

        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);
        props.put(ProducerConfig.RETRIES_CONFIG, 5);
        props.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, 3000);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String,SampleClass> kafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

}
