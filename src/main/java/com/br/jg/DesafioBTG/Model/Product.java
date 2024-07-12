package com.br.jg.DesafioBTG.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    @JsonProperty("produto")
    private String produto;
    @Column(nullable = false)
    @JsonProperty("quantidade")
    private int quantidade;
    @Column(nullable = false)
    @JsonProperty("preco")
    private double preco;

    @Override
    public String toString() {
        return "Product{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
