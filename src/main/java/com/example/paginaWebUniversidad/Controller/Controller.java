package com.example.paginaWebUniversidad.Controller;

import com.example.paginaWebUniversidad.Model.Asignacion;
import com.example.paginaWebUniversidad.Model.Curso;

import com.example.paginaWebUniversidad.Model.Usuario;
import com.example.paginaWebUniversidad.Repository.AsignacionRepository;
import com.example.paginaWebUniversidad.Repository.CursoRepository;
import com.example.paginaWebUniversidad.Repository.UsuarioRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String Hello(){
        return "Test Controller";
    }

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

    @PostMapping("/saveAsignacion")
    public String saveAsignacion(@RequestBody Asignacion asignacion) {
        asignacionRepository.save(asignacion);
        return "Saved Asignacion";
    }
    
    @GetMapping("/getAsignaciones")
    public List<Asignacion> getAsignacionRepository() {
        return asignacionRepository.findAll();
    }
    
   
    
    @PostMapping("/saveUsuario")
    public String saveUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Saved Usuario";
    }
    
    @GetMapping("/getUsuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
