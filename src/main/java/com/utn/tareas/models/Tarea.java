package com.utn.tareas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {
    private Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }
}