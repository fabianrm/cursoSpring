package com.lunatics.bancos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "cuentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta extends RepresentationModel<Cuenta> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false, unique = true)
    private String numeroCuenta;

    private float monto;

    public Cuenta(int id, String numeroCuenta) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
    }
}
