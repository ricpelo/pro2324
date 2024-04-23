package clientes;

import java.util.Objects;

public class Cliente implements Cloneable {
    private String dni;
    private String nombre;
    private String apellidos;

    public Cliente(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    protected Cliente clone() throws CloneNotSupportedException {
        return (Cliente) super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // if (obj == null) {
        //     return false;
        // }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        // if (getClass() != obj.getClass()) {
        //     return false;
        // }

        Cliente c = (Cliente) obj;

        return Objects.equals(dni, c.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
