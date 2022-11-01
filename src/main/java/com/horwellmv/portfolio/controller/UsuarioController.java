package com.horwellmv.portfolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horwellmv.portfolio.dto.Mensaje;
import com.horwellmv.portfolio.entity.Usuario;
import com.horwellmv.portfolio.service.UsuarioService;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

@RestController
@CrossOrigin
@RequestMapping(path="/portfolio") 
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/home")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> listaUsuarios= usuarioService.traerUsuarios();
		return new ResponseEntity<List<Usuario>>(listaUsuarios,HttpStatus.OK);
	}
	
	
	@GetMapping("/home/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable("id") Long id){
		if(!usuarioService.existePorId(id))
			return new ResponseEntity<>(new Mensaje("No se encontró el usuario por Id."),HttpStatus.BAD_REQUEST);
		Usuario usuario = usuarioService.usuarioPorId(id).get();
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@PostMapping("/homelog")
	public ResponseEntity<?> createNew(@RequestBody Usuario usuario){
		if(StringUtils.isEmpty(usuario.getNombre()))
            return new ResponseEntity<Object>(new Mensaje("el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getEmail()))
            return new ResponseEntity<Object>(new Mensaje("el email es obligatorio."), HttpStatus.BAD_REQUEST);
		if(usuarioService.existePorEmail(usuario.getEmail()))
            return new ResponseEntity<Object>(new Mensaje("el mail ya existe."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getUsuario()))
            return new ResponseEntity<Object>(new Mensaje("el Usuario es obligatorio."), HttpStatus.BAD_REQUEST);
		if(usuarioService.existePorNombre(usuario.getUsuario()))
            return new ResponseEntity<Object>(new Mensaje("el Usuario ya existe."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getPassword()))
            return new ResponseEntity<Object>(new Mensaje("el password es obligatorio."), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isEmpty(usuario.getRol()))
            usuario.setRol("user");
		if(StringUtils.isEmpty(usuario.getFoto()))
            usuario.setFoto("../../../assets/Picturs/Avatar.png");
		if(StringUtils.isEmpty(usuario.getBanner()))
            usuario.setBanner("../../../assets/Picturs/Banner.png");
		if(StringUtils.isEmpty(usuario.getDescripcion()))
            usuario.setDescripcion("Lorem ipsum, dolor sit amet consectetur Lorem ipsum, dolor sit amet consectetur"
            		+ "adipisicing elit. Lorem, Lorem ipsum, dolor sit amet consecteturLorem ");
		
		usuarioService.guardarUsuario(usuario);
		return new ResponseEntity<Object>(new Mensaje("Usuario creado."),HttpStatus.CREATED);
	}
	
	@PutMapping("/homelog/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id){
		
		Usuario nwUsuario = usuarioService.usuarioPorId(id).get();
		
		if(StringUtils.isEmpty(usuario.getNombre()))
            return new ResponseEntity<Object>(new Mensaje("el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getEmail()))
            return new ResponseEntity<Object>(new Mensaje("el email es obligatorio."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getUsuario()))
            return new ResponseEntity<Object>(new Mensaje("el Usuario es obligatorio."), HttpStatus.BAD_REQUEST);
		if(!StringUtils.equals(usuario.getUsuario(),nwUsuario.getUsuario()))
			if(usuarioService.existePorNombre(usuario.getUsuario()))
				return new ResponseEntity<Object>(new Mensaje("el Usuario ya existe."), HttpStatus.BAD_REQUEST);
		if(!StringUtils.equals(usuario.getEmail(),nwUsuario.getEmail()))
			if(usuarioService.existePorEmail(usuario.getEmail()))
				return new ResponseEntity<Object>(new Mensaje("el Email ya existe."), HttpStatus.BAD_REQUEST);
		if(StringUtils.isEmpty(usuario.getPassword()))
            return new ResponseEntity<Object>(new Mensaje("el password es obligatorio."), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isEmpty(usuario.getRol()))
            usuario.setRol("user");
		if(StringUtils.isEmpty(usuario.getFoto()))
            usuario.setFoto("../../../assets/Picturs/Avatar.png");
		if(StringUtils.isEmpty(usuario.getBanner()))
            usuario.setBanner("../../../assets/Picturs/Banner.png");
		if(StringUtils.isEmpty(usuario.getDescripcion()))
            usuario.setDescripcion("Lorem ipsum, dolor sit amet consectetur Lorem ipsum, dolor sit amet consectetur"
            		+ "adipisicing elit. Lorem, Lorem ipsum, dolor sit amet consecteturLorem ");
		
		
		
		nwUsuario.setNombre(usuario.getNombre());
		nwUsuario.setApellido(usuario.getApellido());
		nwUsuario.setEmail(usuario.getEmail());
		nwUsuario.setUsuario(usuario.getUsuario());
		nwUsuario.setPassword(usuario.getPassword());
		nwUsuario.setRol(usuario.getRol());
		nwUsuario.setProfesion(usuario.getProfesion());
		nwUsuario.setTecnologias(usuario.getTecnologias());
		nwUsuario.setCiudad(usuario.getCiudad());
		nwUsuario.setDescripcion(usuario.getDescripcion());
		nwUsuario.setFoto(usuario.getFoto());
		nwUsuario.setBanner(usuario.getBanner());
		nwUsuario.setBusquedaActiva(usuario.getBusquedaActiva());
		nwUsuario.setGithub(usuario.getGithub());
		nwUsuario.setLinkedin(usuario.getLinkedin());
		
		usuarioService.guardarUsuario(nwUsuario);
		return new ResponseEntity<Object>(new Mensaje("Usuario actualizado"), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/homelog/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if (!usuarioService.existePorId(id))
			return new ResponseEntity<Object>(new Mensaje("No se encontró el usuario por Id."),HttpStatus.BAD_REQUEST);
		usuarioService.borrarUsuario(id);
		return new ResponseEntity<Object>(new Mensaje("Usuario Eliminado correctamente."), HttpStatus.OK);
	}
	

}
