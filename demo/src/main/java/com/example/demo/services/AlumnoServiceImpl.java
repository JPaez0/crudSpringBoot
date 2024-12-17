package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.entity.Alumno;
import com.example.demo.models.repository.AlumnoRepository;


@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository reAlumnoRepository;
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return reAlumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findByID(Long id) {
		// TODO Auto-generated method stub
		return reAlumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return reAlumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void delteById(Long id) {
		reAlumnoRepository.deleteById(id);

	}

}
