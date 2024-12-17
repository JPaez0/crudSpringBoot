package com.example.demo.services;

import java.util.Optional;

import com.example.demo.models.entity.Alumno;

public interface AlumnoService {
	public Iterable<Alumno> findAll();
	public Optional<Alumno> findByID(Long id);
	public Alumno save(Alumno alumno);
	public void delteById(Long id);

}
