package com.lg.entity;

public class Productos {
	
		// Atributos privados de la clase Productos, que almacenan la información del producto.
        private Integer id;
        private Integer cantidad;
        private String nombre;
        private double precio;
        
        //Metodos Getters y Setters
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getCantidad() {
			return cantidad;
		}
		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		// Método toString que sobrescribe el método por defecto de la clase Object.
		// para facilitar la visualización de sus valores
	    public String toString() {
	        return "Producto id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", cantidad=" + cantidad + "";
	    }


    }
