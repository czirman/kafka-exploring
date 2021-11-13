package org.czirman.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
public class KafkaExploreApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaExploreApplication.class, args);
    }

    @Bean
    public LongMessageListener longMessageListener() {
        return new LongMessageListener();
    }

    public static class LongMessageListener {
        @KafkaListener(topics = "quickstart-events")
        public void listenWithHeaders(
                @Payload String message,
                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
            System.out.println("Received Message: "+ "from partition: " + partition);
        }
    }

}

