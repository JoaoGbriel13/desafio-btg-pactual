package com.br.jg.DesafioBTG.Controller;

import com.br.jg.DesafioBTG.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders/{id}")
    public ResponseEntity getAllByClient(@PathVariable("id") Long codigoCliente){
        return orderService.getAllByClient(codigoCliente);
    }
    @GetMapping("/order-number/{id}")
    public ResponseEntity getNumberOfOrders(@PathVariable("id") Long codigoCliente){
        return orderService.getQuantityByClient(codigoCliente);
    }
    @GetMapping("/order-value/{id}")
    public ResponseEntity getValueOfOrder(@PathVariable("id") Long codigoPedido){
        return orderService.getTotalValue(codigoPedido);
    }

}
