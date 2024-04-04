import java.util.Arrays;

class Usuario {

}

class Grupo {
    private Usuario[] usuarios = new Usuario[5];
    private int cantidadUsuarios = 0;

    public void insertar(Usuario usuario) {
        if (cantidadUsuarios >= usuarios.length) {
            usuarios = Arrays.copyOf(usuarios, (int) (usuarios.length * 1.5f));
        }
        usuarios[cantidadUsuarios++] = usuario;
    }

    public Usuario[] getUsuarios() {
        return Arrays.copyOf(usuarios, cantidadUsuarios);
    }
}
