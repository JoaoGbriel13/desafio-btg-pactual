package com.br.jg.DesafioBTG.Service;

import com.br.jg.DesafioBTG.Model.Order;
import com.br.jg.DesafioBTG.Repository.OrderRepository;
import com.br.jg.DesafioBTG.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.br.jg.DesafioBTG.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Service
public class RabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderRepository orderRepository;

    public void sendOrder(OrderCreatedEvent orderCreatedEvent){
        rabbitTemplate.convertAndSend(ORDER_CREATED_QUEUE, orderCreatedEvent);
    }
    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void receiveMessage(OrderCreatedEvent orderCreatedEvent){
        Order order = new Order(orderCreatedEvent.codigoPedido(), orderCreatedEvent.codigoCliente(), orderCreatedEvent.itens());
        orderRepository.save(order);
    }
    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
