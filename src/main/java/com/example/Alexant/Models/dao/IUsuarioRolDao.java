package com.example.Alexant.Models.dao;
 
import org.springframework.data.repository.CrudRepository;
 
import com.example.Alexant.Models.entitys.UsuarioRol;

public interface IUsuarioRolDao extends CrudRepository<UsuarioRol, Integer> {

	// @Query ("select d from UsuarioRol d where d.id_usuario=?1 and d.estado_usr_rol='A'")
    // List<UsuarioRol>listRolesUsuario(Usuario usuario);
} 