package com.lg.main;

import com.lg.interfaces.implementacion.*; // Importación de la clase ProductoImpl

public class Main {
    public static void main(String[] args) {
    	// Se crea una instancia del servicio ProductoImpl
        ProductoImpl servicio = new ProductoImpl();
        
        // Creación de productos utilizando el método 'crearProducto'
        var producto1 = servicio.crearProducto(1, "Laptop", 899.99, 2);
        var producto2 = servicio.crearProducto(2, "Teclado", 45.50, 10);
        var producto3 = servicio.crearProducto(3, "Mouse", 20.50, 3);
        var producto4 = servicio.crearProducto(4, "Monitor", 300.00, 5);
        
        // Se agregan los productos creados a la lista de productos mediante el método 'agregarProducto'
        servicio.agregarProducto(producto1);
        servicio.agregarProducto(producto2);
        servicio.agregarProducto(producto3);
        servicio.agregarProducto(producto4);

        // Se imprime la lista antes de los cambios
        System.out.println("Lista inicial:");
        servicio.listarProductos();
        
        /* Busca e imprime el ID que necesitemos en este caso el 1, pero se puede cambiar por cualquier
        ID que se tenga creado*/
        System.out.println("\nBuscar ID 1:");
        System.out.println(servicio.buscarPorId(1)); // El ID que se buscara y se imprimira
        
        // Se elimina el producto con el ID que queramos
        System.out.println("\nEliminar ID 2:");
        servicio.eliminarProducto(1);

        // Imprime la lista ya con los cambios aplicados
        System.out.println("\nLista final:");
        servicio.listarProductos();
    }
}
