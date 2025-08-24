package com.lg.taller.consola;

import com.lg.taller.entity.Cliente;
import com.lg.taller.entity.Vehiculo;
import com.lg.taller.entity.Servicio;
import com.lg.taller.service.ClienteService;
import com.lg.taller.service.VehiculoService;
import com.lg.taller.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class PruebaConsola implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ServicioService ServicioService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== TALLER AUTOMOTRIZ ====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Ver todos los clientes");
            System.out.println("3. Crear vehículo");
            System.out.println("4. Ver vehículos de un cliente");
            System.out.println("5. Crear orden de servicio");
            System.out.println("6. Ver órdenes por vehículo");
            System.out.println("7. Ver detalle completo de un cliente");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    clienteService.guardar(new Cliente(nombre, tel, correo));
                    System.out.println("Cliente creado.");
                }
                case 2 -> clienteService.listar().forEach(c ->
                        System.out.println(c.getId() + " - " + c.getNombre() + " (" + c.getCorreo() + ")")
                );
                case 3 -> {
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("ID del cliente dueño: ");
                    Long idCliente = scanner.nextLong();
                    scanner.nextLine();

                    Optional<Cliente> cliente = clienteService.obtenerPorId(idCliente);
                    if (cliente.isPresent()) {
                        Vehiculo v = new Vehiculo(marca, modelo, anio, placa, cliente.get());
                        vehiculoService.guardar(v);
                        System.out.println("Vehículo registrado.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID del cliente: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    List<Vehiculo> vehiculos = vehiculoService.listarPorCliente(id);
                    vehiculos.forEach(v ->
                            System.out.println(v.getId() + " - " + v.getMarca() + " " + v.getModelo() + " (" + v.getPlaca() + ")")
                    );
                }
                case 5 -> {
                    System.out.print("Fecha (AAAA-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(fechaStr);
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Costo: ");
                    double costo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("ID del vehículo: ");
                    Long idVehiculo = scanner.nextLong();
                    scanner.nextLine();

                    Optional<Vehiculo> vehiculo = vehiculoService.obtenerPorId(idVehiculo);
                    if (vehiculo.isPresent()) {
                        Servicio orden = new Servicio(fecha, desc, costo, vehiculo.get());
                        ServicioService.guardar(orden);
                        System.out.println("Orden registrada.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("ID del vehículo: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    List<Servicio> ordenes = ServicioService.listarPorVehiculo(id);
                    ordenes.forEach(o -> {
                        System.out.println(o.getId() + " - " + o.getFecha() + " | Q" + o.getCosto());
                        System.out.println("  " + o.getDescripcion());
                    });
                }
                case 7 -> {
                    System.out.print("ID del cliente: ");
                    Long clienteId = scanner.nextLong();
                    scanner.nextLine();

                    Optional<Cliente> clienteOpt = clienteService.obtenerPorId(clienteId);
                    if (clienteOpt.isEmpty()) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    Cliente cliente = clienteOpt.get();
                    System.out.println("\nCliente: " + cliente.getNombre() + " | " + cliente.getCorreo());

                    List<Vehiculo> vehiculos = vehiculoService.listarPorCliente(clienteId);
                    if (vehiculos.isEmpty()) {
                        System.out.println("Este cliente no tiene vehículos registrados.");
                        break;
                    }

                    for (Vehiculo v : vehiculos) {
                        System.out.println("  Vehículo ID: " + v.getId() + " | " + v.getMarca() + " " + v.getModelo() + " (" + v.getPlaca() + ")");

                        List<Servicio> ordenes = ServicioService.listarPorVehiculo(v.getId());
                        if (ordenes.isEmpty()) {
                            System.out.println("    → Sin órdenes de servicio registradas.");
                        } else {
                            for (Servicio o : ordenes) {
                                System.out.println("    → Orden ID: " + o.getId() + " | Fecha: " + o.getFecha() + " | Costo: Q" + o.getCosto());
                                System.out.println("      Descripción: " + o.getDescripcion());
                            }
                        }
                    }
                }
                case 8 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
