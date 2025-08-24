package ls.interfaces;

import ls.entity.Usuarios;

public interface Iusuario {
    void agregarUsuario(Usuarios usuario);  // Agregar un usuario
    Usuarios buscarPorId(int id);           // Buscar un usuario por su ID
    void eliminarUsuario(int id);          // Eliminar un usuario por su ID
    void listarUsuarios();  
}
