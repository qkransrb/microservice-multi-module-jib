package com.amigoscode.notification.rabbitmq;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("> Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
