## Proyecto: Fundamentos de Spring Boot - Tareas

### Descripción

Este proyecto implementa una pequeña lógica de manejo de tareas (entidad `Tarea`) y demuestra conceptos clave de Spring Boot como perfiles (`dev` y `prod`), inyección de dependencias, servicios y repositorios.

La aplicación incluye dos implementaciones de servicio de mensajería para distinguir comportamientos entre los perfiles `dev` y `prod`.

### Tecnologías utilizadas

-   Java 17+
-   Spring Boot
-   Maven (con wrapper `mvnw` / `mvnw.cmd`)

### Estructura relevante

-   `src/main/java/com/utn/tareas` - código fuente (Application, model, repository, service)
-   `src/main/resources/application-dev.properties` - properties para profile `dev`
-   `src/main/resources/application-prod.properties` - properties para profile `prod`
-   `src/main/resources/application.properties` - configuración común

### Clonar el repositorio

Abre una terminal y ejecuta:

```powershell
git clone https://github.com/AntoAldao/FundamentosDeSpringBootTareas.git
```

### Ejecutar la aplicación (modo rápido)

Usa el wrapper incluido para ejecutar la aplicación sin instalar Maven globalmente.

En Windows PowerShell (desde la raíz del proyecto):

```powershell
# Ejecutar con profile dev
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev

# Ejecutar con profile prod
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod
```

### Cómo cambiar entre perfiles (dev / prod)

1. Usando la propiedad del plugin `spring-boot.run.profiles` con Maven: `-Dspring-boot.run.profiles=dev` o `prod`.
2. Estableciendo la variable de entorno `SPRING_PROFILES_ACTIVE` antes de ejecutar.
3. Pasando el parámetro `--spring.profiles.active=dev` al ejecutar el JAR.

Los archivos de configuración están en `src/main/resources`:

-   `application-dev.properties` — configuración para desarrollo
-   `application-prod.properties` — configuración para producción
-   `application.properties` — valores comunes

Spring seleccionará automáticamente el archivo `application-{profile}.properties` correspondiente cuando se active el profile.

### Capturas de pantalla de la consola

Se encuentran las capturas de pantalla en la carpeta `capturas/` del repositorio

### Conclusiones personales

1. Aprendí a usar perfiles en Spring Boot para separar configuraciones de desarrollo y producción, lo que facilita probar comportamientos distintos sin cambiar código.
2. Entendí la utilidad del `@Service` y `@Repository` y la inyección de dependencias para mantener el código desacoplado y testeable.
3. Practiqué el uso del Maven Wrapper (`mvnw`) para correr y empaquetar el proyecto sin depender de la instalación del desarrollador.
4. Vi la importancia de mantener las propiedades sensibles fuera del repositorio (usar mecanismos como variables de entorno o vault en entornos reales).

### Nombre y legajo

-   Nombre: Antonella Aldao
-   Legajo: 50715

---
