## API de Transferencias

Este proyecto es una aplicación Java usando Spring Boot que permite gestionar cuentas y realizar transferencias entre ellas mediante una API REST documentada con Swagger.

---

## Requisitos para ejecutar

1. Tener instalado **XAMPP** y que el servicio de **MySQL esté activo**.
2. Crear una base de datos llamada: transferencias_db (se encuentra dentro de los archivos del proyecto)
3. Descargar el proyecto, y ejecutar la aplicación desde tu IDE en este caso se usó: IntelliJ
4. Ir al navegador y abrir Swagger en la siguiente URL: http://localhost:8080/swagger-ui/index.html
5. Desde ahí se puede probar las funciones del proyecto tales como: crear cuentas, realizar transferencias y mostrar las cuentas ya existentes

---

## Explicación de las clases principales

| Clase                          | Descripción breve                                                                            |
|--------------------------------|----------------------------------------------------------------------------------------------|
| `Cuenta`                       | Entidad que representa a un usuario con su nombre y saldo                                    |
| `CuentaController`             | Controlador REST para consultar y crear cuentas                                              |
| `TransferenciaController`      | Controlador REST para realizar una transferencia                                             |
| `TransferenciaDTO`             | Objeto que contiene el ID de la cuenta origen, destino y el monto                            |
| `TransferenciaServiceImpl`     | Contiene la lógica para mover el saldo de una cuenta a otra                                  |
| `CuentaRepository`             | Repositorio que interactúa con la base de datos                                              |
| `CuentaNotFoundException`      | Excepción lanzada si una cuenta no existe                                                    |
| `SaldoInsuficienteException`   | Excepción lanzada si la cuenta origen no tiene saldo suficiente                              |
| `SwaggerConfig`                | Configura la documentación automática con Swagger                                            |

---

## Tecnologías

- Java 17 ☕
- Spring Boot 3.4.4
- Spring Web, Data JPA, Validation 
- MySQL con conexión vía `mysql-connector-j`
- Swagger

---

## Diagrama UML

![uml_transferencias_tarea](https://github.com/user-attachments/assets/1711d23c-3182-45db-8ab2-ab2507c3cf3c)




