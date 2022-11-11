package com.vreijsenj.streaming.producer.sender;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class KinesisSender {

    private final KinesisProducer producer;

    @PostConstruct
    public void run() throws ExecutionException, InterruptedException {
        ByteBuffer payload = ByteBuffer.wrap("{ 'data': 'Something important.' }".getBytes(StandardCharsets.UTF_8));
        producer.addUserRecord("some-data-stream", "partitionKey", payload).get();
    }
}