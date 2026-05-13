package com.example.crud_mvc.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ingrese el nombre del producto")
    private String nombre;
    @Positive(message = "Precio invalido")
    private BigDecimal precio;
    @Min(value = 1, message = "Cantidad mínimo 1")
    private int cantidad;

    @NotNull
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

}