package com.br.jg.DesafioBTG.Repository;

import com.br.jg.DesafioBTG.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCodigoCliente(Long codigoCliente);

    Optional<Order> findByCodigoPedido(Long codigoPedido);
}