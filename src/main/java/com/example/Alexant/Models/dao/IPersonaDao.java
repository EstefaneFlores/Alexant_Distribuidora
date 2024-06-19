package com.example.Alexant.Models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona p where p.nombre=?1 and p.ap_paterno=?2 and p.ap_materno=?3 and p.ci=?4 and p.correo=?5 and p.telefono=?6")
	public Persona getPersona(String nombre, String ap_paterno, String ap_materno, String ci, String correo,
			String telefono);

	@Query("select p from Persona p where p.ci=?1 and p.correo=?2")
	public Persona getPersonaCiCorreo(String ci, String correo);

	@Query("select p from Persona p where p.ci like %?1% and p.correo like %?2%")
	public List<Persona> getAllPersonaCiCorreo(String ci, String correo);

	@Query(value = "SELECT * FROM persona p WHERE p.ci = :ci and p.estado_persona !='X'", nativeQuery = true)
	public Persona getPersonaCi2(String ci);

	@Query(value = "SELECT * FROM persona p where p.correo=?1 LIMIT 1", nativeQuery = true)
	public Persona getPersonaCorreo2(String correo);

	@Query(value = "SELECT * FROM persona AS p LEFT JOIN usuario AS u ON p.id_persona  = u.id_persona WHERE u.id_persona IS NULL;", nativeQuery = true)
	public List<Persona> listaPersonasSinUsuarios();

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD') LIMIT 1", nativeQuery = true)
    Persona buscarPorCi(String ci);

    @Query("select p from Persona p where p.estado_persona != 'X'")
    public List<Persona> getListarPersonasActivas();
    

}
