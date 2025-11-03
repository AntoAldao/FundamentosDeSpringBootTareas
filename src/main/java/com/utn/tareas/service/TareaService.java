package com.utn.tareas.service;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.nombre}")
    private String nombreApp;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void imprimirConfiguracion() {
        System.out.println("Nombre App: " + nombreApp);
        System.out.println("Max tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
    }

    public Tarea agregarTarea(String descripcion, Tarea.Prioridad prioridad) {
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            throw new RuntimeException("Se alcanzó el límite máximo de tareas");
        }
        return tareaRepository.guardar(new Tarea(null, descripcion, false, prioridad));
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream().filter(t -> !t.isCompletada()).collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream().filter(Tarea::isCompletada).collect(Collectors.toList());
    }

    public void marcarComoCompletada(Long id) {
        tareaRepository.buscarPorId(id).ifPresent(t -> t.setCompletada(true));
    }

    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) return "Estadísticas deshabilitadas";
        List<Tarea> todas = tareaRepository.obtenerTodas();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = todas.size() - completadas;
        return String.format("Total: %d, Completadas: %d, Pendientes: %d", todas.size(), completadas, pendientes);
    }
}