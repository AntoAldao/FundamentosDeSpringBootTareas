package com.utn.tareas;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

	private final TareaService tareaService;
	private final MensajeService mensajeService;

	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.tareaService = tareaService;
		this.mensajeService = mensajeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mensajeService.mostrarBienvenida();
		tareaService.imprimirConfiguracion();
		System.out.println("Tareas iniciales:");
		tareaService.listarTodas().forEach(System.out::println);

		tareaService.agregarTarea("Nueva tarea de prueba", Tarea.Prioridad.ALTA);
		System.out.println("Tareas pendientes:");
		tareaService.listarPendientes().forEach(System.out::println);

		tareaService.marcarComoCompletada(1L);
		System.out.println("Estadísticas:");
		System.out.println(tareaService.obtenerEstadisticas());

		System.out.println("Tareas completadas:");
		tareaService.listarCompletadas().forEach(System.out::println);

		mensajeService.mostrarDespedida();
	}
}
