package com.example.demo.controlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Alumno;
import com.example.demo.services.AlumnoService;

@RestController
public class AlumnoControllers {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(alumnoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Alumno> o = alumnoService.findByID(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());

	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
		Alumno alumnoDb = alumnoService.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Alumno> o = alumnoService.findByID(id);

		if (o.isEmpty()) {
			return  ResponseEntity.notFound().build();
		}
		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <? > eliminar(@PathVariable Long id){
		alumnoService.delteById(id);
	     return ResponseEntity.noContent().build();
	     
	}
	
}
