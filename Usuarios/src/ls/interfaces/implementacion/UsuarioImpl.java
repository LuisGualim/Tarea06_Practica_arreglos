package ls.interfaces.implementacion;

import ls.interfaces.Iusuario;
import ls.entity.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioImpl implements Iusuario {

    private List<Usuarios> listaUsuarios = new ArrayList<>();
    private Map<Integer, Usuarios> mapaUsuarios = new HashMap<>();

    public void agregarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);  // Añadir a la lista
        mapaUsuarios.put(usuario.getId(), usuario);  
    }

    @Override
    public Usuarios buscarPorId(int id) {
        return mapaUsuarios.get(id);  // Buscar en el mapa por ID
    }

    public void eliminarUsuario(int id) {
    	Usuarios usuario = mapaUsuarios.remove(id);  // Eliminar del mapa
        if (usuario != null) {
            listaUsuarios.remove(usuario);  // Eliminar de la lista si existe
        }
    }

    @Override
    public void listarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios en la lista.");
        } else {
            listaUsuarios.forEach(System.out::println);  // Imprimir todos los usuarios
        }
    }
}