package com.foro.hub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String mensaje;

    @NotNull
    private String autor;

    @NotNull
    private String curso;

    private LocalDate fechaCreacion = LocalDate.now();

    private String estado;

    // Getters and Setters
}
