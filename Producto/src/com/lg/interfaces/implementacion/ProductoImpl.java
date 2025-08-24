package com.lg.interfaces.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Se importan las interfaces y clases necesarias 
import com.lg.interfaces.*;
import com.lg.entity.*;

//La clase ProductoImpl implementa la interfaz Iproducto
public class ProductoImpl implements Iproducto {

	 /* Se crea una lista para almacenar los productos. Utilizamos un ArrayList para permitir
	añadir, buscar y listar productos.*/
    private List<Productos> listaProductos = new ArrayList<>();
    
    // Se crea un mapa (HashMap) para almacenar los productos por su ID
    private Map<Integer, Productos> mapaProductos = new HashMap<>();

    /* El parámetro 'producto' es un objeto de tipo Object, que es convertido a un objeto de tipo
    'Productos' en tiempo de ejecución*/
    public void agregarProducto(Object producto) {
    	//Se añade el producto
        listaProductos.add((Productos) producto);
        // Se agrega el producto al mapa usando su ID como clave.
        mapaProductos.put(((Productos) producto).getId(), (Productos) producto);
    }

    // Método que utiliza el mapa (HashMap) para obtener el producto por ID
    public Productos buscarPorId(int id) {
        return mapaProductos.get(id);
    }

    // Este método elimina primero el producto del mapa
    public void eliminarProducto(int id) {
    	Productos producto = mapaProductos.remove(id); // Elimina del mapa
        if (producto != null) {
            listaProductos.remove(producto); // Elimina de la lista
        }
    }

    // Si la lista está vacía, brind un mensaje indicándolo, de lo contrario, imprime cada producto.
    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            listaProductos.forEach(System.out::println);
        }
    }

    // Método de ayuda para crear productos
    // Se utiliza este método para facilitar la creación de productos en el sistema.
    public Productos crearProducto(int id, String nombre, double precio, int cantidad) {
    	Productos producto = new Productos();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        return producto;
    }
}
