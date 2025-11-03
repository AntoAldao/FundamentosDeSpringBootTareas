package com.utn.tareas.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") // Solo se activa si el profile activo es "dev"
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("¡Bienvenido al entorno DEV! Disfruta de los logs detallados y configuraciones de prueba.");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("¡Hasta luego, DEV! No olvides revisar tus tareas pendientes.");
    }
}