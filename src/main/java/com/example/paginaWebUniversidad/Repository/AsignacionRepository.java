package com.example.paginaWebUniversidad.Repository;
import com.example.paginaWebUniversidad.Model.Asignacion;
import com.example.paginaWebUniversidad.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    void deleteByCursoId(Long cursoId);
    List<Asignacion> findByUsuario(Usuario usuario);
}
