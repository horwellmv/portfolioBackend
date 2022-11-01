package com.horwellmv.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horwellmv.portfolio.entity.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
	
	boolean existsByUsuario(String nombreUsuario);
	
	boolean existsByEmail(String email);
}
