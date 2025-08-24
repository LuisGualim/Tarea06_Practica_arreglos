package com.lg.interfaces;

public interface Iproducto {
	//Metodos para Agregar, buscar, eliminar y listar productos
    void agregarProducto(Object producto);
    Object buscarPorId(int id);
    void eliminarProducto(int id);
    void listarProductos();
}
