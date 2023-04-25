package com.jeremias.dev.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "cliente_id_sequence",
            sequenceName = "cliente_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_id_sequence"
    )
    private Integer id;
    private String nombres;
    private String apellidos;
    private String email;
}
