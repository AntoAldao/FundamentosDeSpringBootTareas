package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod") // Solo se activa si el profile activo es "prod"
public class MensajeProdService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido. La aplicación está en modo producción.");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Adiós. Hasta la próxima ejecución.");
    }
}