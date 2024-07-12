package com.br.jg.DesafioBTG.Service;

import com.br.jg.DesafioBTG.Model.Order;
import com.br.jg.DesafioBTG.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity getAllByClient(Long codigoCliente){
        var orders = orderRepository.findAllByCodigoCliente(codigoCliente);
        if (orders.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
    }
    public ResponseEntity getQuantityByClient(Long codigoCliente){
        var orders = orderRepository.findAllByCodigoCliente(codigoCliente).size();
        if (orders == 0){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não há pedidos para o cliente buscado.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("O cliente já fez um total de: " + orders + " pedidos" );
    }

    public ResponseEntity getTotalValue(Long codigoPedido){
        var order = orderRepository.findByCodigoPedido(codigoPedido);
        if (order.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não foi encontrado nenhum pedido");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("O valor total da compra foi de: " + calcularTotalPedido(order.get()));
    }

    private String calcularTotalPedido(Order order){
        double valor = order.getItens().stream().mapToDouble(v -> v.getPreco() * v.getQuantidade()).sum();
        return String.format("%.2f", valor);
    }
}
