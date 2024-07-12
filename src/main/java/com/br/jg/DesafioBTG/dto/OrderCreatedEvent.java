package com.br.jg.DesafioBTG.dto;

import com.br.jg.DesafioBTG.Model.Product;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido, Long codigoCliente, List<Product> itens) {
}
