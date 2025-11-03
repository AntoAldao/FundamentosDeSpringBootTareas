package com.utn.tareas.repository;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public TareaRepository() {
        tareas.add(new Tarea(contador.getAndIncrement(), "Comprar leche", false, Tarea.Prioridad.MEDIA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Estudiar Spring Boot", false, Tarea.Prioridad.ALTA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Hacer ejercicio", true, Tarea.Prioridad.BAJA));
    }

    public Tarea guardar(Tarea tarea) {
        tarea.setId(contador.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public boolean eliminarPorId(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}