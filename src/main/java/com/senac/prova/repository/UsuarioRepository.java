package com.senac.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.prova.entity.Usuario;

@Repository
public interface UsuarioRepository extends  JpaRepository<Usuario, Integer>{

}
