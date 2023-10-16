package com.example.paginaWebUniversidad.Repository;
import com.example.paginaWebUniversidad.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
