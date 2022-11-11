package com.vreijsenj.streaming.producer.configuration;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("localstack")
@Configuration
public class LocalStackConfiguration {

    @Bean
    public KinesisProducer kinesisProducer() {
        KinesisProducerConfiguration configuration = new KinesisProducerConfiguration()
            .setKinesisEndpoint("localhost")
            .setKinesisPort(4567)
            .setCloudwatchEndpoint("localhost")
            .setCloudwatchPort(4567)
            .setRegion("us-east-1")
            .setVerifyCertificate(false);

        return new KinesisProducer(configuration);
    }
}