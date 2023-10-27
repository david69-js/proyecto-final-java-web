package com.example.paginaWebUniversidad.Controller;

import com.example.paginaWebUniversidad.Model.Asignacion;
import com.example.paginaWebUniversidad.Model.Curso;

import com.example.paginaWebUniversidad.Model.Usuario;
import com.example.paginaWebUniversidad.Repository.AsignacionRepository;
import com.example.paginaWebUniversidad.Repository.CursoRepository;
import com.example.paginaWebUniversidad.Repository.UsuarioRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping(value = "/saveCurso")
    public String saveCurso(@RequestBody Curso curso) {
        cursoRepository.save(curso);
        return "Saved Curso";
    }
    @GetMapping("/getCursos")
    public List<Curso> getCursoRepository() {
        return cursoRepository.findAll();
    }

    @GetMapping("/getCurso/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateCurso/{id}")
    public ResponseEntity<String> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> existingCurso = cursoRepository.findById(id);
        if (existingCurso.isPresent()) {
            Curso updatedCurso = existingCurso.get();
            // Realiza las modificaciones necesarias en el curso existente
            updatedCurso.setNombreCurso(curso.getNombreCurso());
            updatedCurso.setDescripcion(curso.getDescripcion());
            // Puedes actualizar otros campos según sea necesario

            cursoRepository.save(updatedCurso);
            return ResponseEntity.ok("Curso actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteCurso/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            // Eliminar las asignaciones relacionadas al curso
            asignacionRepository.deleteByCursoId(id);

            // Luego eliminar el curso
            cursoRepository.delete(curso.get());
            return ResponseEntity.ok("Curso eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/saveAsignacion")
    public String saveAsignacion(@RequestBody Asignacion asignacion) {
        asignacionRepository.save(asignacion);
        return "Saved Asignacion";
    }
    
    @GetMapping("/getAsignaciones")
    public List<Asignacion> getAsignacionRepository() {
        return asignacionRepository.findAll();
    }

    @GetMapping("/getAsignacionesByUsuario/{usuarioId}")
    public List<Asignacion> getAsignacionesByUsuario(@PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if (usuario.isPresent()) {
            return asignacionRepository.findByUsuario(usuario.get());
        } else {
            // Puedes manejar el caso en el que el usuario no existe o no se encontraron asignaciones.
            return Collections.emptyList();
        }
    }



    @PostMapping("/saveUsuario")
    public String saveUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Saved Usuario";
    }
    
    @GetMapping("/getUsuario/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/getUsuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
    
}
