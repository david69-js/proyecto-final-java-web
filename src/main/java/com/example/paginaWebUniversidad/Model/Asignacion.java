package com.example.paginaWebUniversidad.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(schema = "asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long usuarioId;

    private long cursoId;

    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cursoId", referencedColumnName = "id", insertable = false, updatable = false)
    private Curso curso;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    
    public void setCursoId(long cursoId) {
        this.cursoId = cursoId;
    }

    public long getCursoId() {
        return cursoId;
    }

    public void setUsuario(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }
   
    
   

}
