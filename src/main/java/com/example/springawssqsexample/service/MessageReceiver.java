package com.example.springawssqsexample.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class MessageReceiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

  @Autowired
  private SqsTemplate sqsTemplate;

  @SqsListener("test-queue")
  public void listen(Message<?> message) {
    /*
     * LOGGER.info("Message received on listen method at {}", OffsetDateTime.now());
     * LOGGER.info("Processing Failed", OffsetDateTime.now());
     *  int x = 5 / 0 ; // Exception
     *  Acknowledgement.acknowledge(message);
     */
    LOGGER.info("Message received on listen method at {} and message was {}", OffsetDateTime.now(), message);
    Acknowledgement.acknowledge(message);
  }

  // this method should be called in an infinite loop
   /*
   public void receive(){
        sqsTemplate
                .receive(from -> from.queue("test-queue") );
    }*/
}
