package com.horwellmv.portfolio.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horwellmv.portfolio.entity.Usuario;
import com.horwellmv.portfolio.repository.IUsuarioRepository;


@Service
@Transactional
public class UsuarioService {
	@Autowired
	IUsuarioRepository usuarioRepo;
	
    public List<Usuario> traerUsuarios(){
        List<Usuario> lista = usuarioRepo.findAll();
        return lista;
    }
	
    public boolean existePorId(Long id){
        return usuarioRepo.existsById(id);
    }
    
    public boolean existePorNombre(String nombreUsuario){
        return usuarioRepo.existsByUsuario(nombreUsuario);
    }
    
    public boolean existePorEmail(String emailUsuario) {
    	return usuarioRepo.existsByEmail(emailUsuario);
    }
    
	public Optional<Usuario> usuarioPorId(Long id){
		return usuarioRepo.findById(id);
	}
	
	public void guardarUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
	
	public void borrarUsuario(Long id) {
		usuarioRepo.deleteById(id);
	}

}
