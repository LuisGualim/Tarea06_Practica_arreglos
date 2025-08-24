package ls.main;

import ls.entity.*;
import ls.interfaces.implementacion.*;

public class Main {
	public static void main(String[] args) {
        UsuarioImpl servicio = new UsuarioImpl();

        Usuarios usuario1 = new Usuarios(1, "Juan Pérez", "juan@example.com");
        servicio.agregarUsuario(usuario1);
        
        System.out.println("Lista inicial de usuarios:");
        servicio.listarUsuarios();

        System.out.println("\nBuscar usuario con ID 1:");
        System.out.println(servicio.buscarPorId(1));

        System.out.println("\nEliminar usuario con ID 2:");
        servicio.eliminarUsuario(2);

        System.out.println("\nLista final de usuarios:");
        servicio.listarUsuarios();
    }
}
