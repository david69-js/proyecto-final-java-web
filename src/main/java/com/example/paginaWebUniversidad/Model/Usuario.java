package com.example.paginaWebUniversidad.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;

    @NotNull
    private String nombreAlumno;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String contrasenia;

    @Column
    private boolean esAdmin;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public boolean getEsAdmin() {
        return esAdmin;
    }

}
