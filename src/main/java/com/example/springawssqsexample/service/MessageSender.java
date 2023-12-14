package com.example.springawssqsexample.service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

  @Autowired
  private SqsTemplate sqsTemplate;

  @Value("${microservice.albUrl}")
  public String apiUrl;

  public void sendMessage(String message) {

    System.out.println("apiUrl>>>>>>>>>>>"+apiUrl);

    sqsTemplate
    .send(sqsSendOptions ->
        sqsSendOptions
            .queue("test-queue")
            .payload(message)
    );
  }
}
