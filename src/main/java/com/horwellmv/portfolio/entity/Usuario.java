package com.horwellmv.portfolio.entity;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable=false, length=50)
	private String nombre;
	
    @Column(nullable=true, length=50)
	private String apellido;
    
    @Column(unique = true ,nullable=false, length=500)
    private String email;
	
    @Column(unique=true, nullable=false, length=50)
	private String usuario;
	
    @Column(nullable=false, length=500)
	private String password;
	
    @Column
	private String rol;
    
    @Column
	private String profesion;
	
	@Column(length = 2500)
	private String tecnologias;
	
	@Column
	private String ciudad;
	
	@Column(length = 4000)
	private String descripcion;
	
	@Column(length = 2500)
	private String foto;
	
	@Column(length = 2500)
	private String banner;
	
	@Column
	private String github;
	
	@Column
	private String linkedin;
	
	@Column
	private Boolean busquedaActiva;
	

	// ------------------------------ Constructors
	
	public Usuario() {
		
	}

	public Usuario(String nombre, String apellido, String email, String usuario, String password, String rol,
			String profesion, String tecnologias, String ciudad, String descripcion, String foto, String banner,
			String github, String linkedin, Boolean busquedaActiva) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.profesion = profesion;
		this.tecnologias = tecnologias;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.foto = foto;
		this.banner = banner;
		this.github = github;
		this.linkedin = linkedin;
		this.busquedaActiva = busquedaActiva;
	}
	// -------------------------------------- Getters & Setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public String getTecnologias() {
		return tecnologias;
	}


	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getBanner() {
		return banner;
	}


	public void setBanner(String banner) {
		this.banner = banner;
	}


	public String getGithub() {
		return github;
	}


	public void setGithub(String github) {
		this.github = github;
	}


	public String getLinkedin() {
		return linkedin;
	}


	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}


	public Boolean getBusquedaActiva() {
		return busquedaActiva;
	}


	public void setBusquedaActiva(Boolean busquedaActiva) {
		this.busquedaActiva = busquedaActiva;
	}

	
}