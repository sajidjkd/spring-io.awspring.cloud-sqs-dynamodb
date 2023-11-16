package com.example.springawssqsexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfig {

    @Bean
    DynamoDbClient getDynamoDBClient() {
        return DynamoDbClient.builder().build();
    }

    @Bean
    DynamoDbEnhancedClient getDynamoDbEnhancedClient() {
        return DynamoDbEnhancedClient.builder().dynamoDbClient(getDynamoDBClient()).build();
    }
}
