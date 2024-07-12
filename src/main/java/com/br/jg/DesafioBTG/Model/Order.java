package com.br.jg.DesafioBTG.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_order", indexes = {
        @Index(name = "idx_order_codigo_cliente", columnList = "codigo_cliente")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty("codigoPedido")
    private Long codigoPedido;
    @JsonProperty("codigoCliente")
    private Long codigoCliente;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("itens")
    private List<Product> itens;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "codigoPedido = " + codigoPedido + ", " +
                "codigoCliente = " + codigoCliente + ")";
    }
}
