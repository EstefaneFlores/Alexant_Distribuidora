package com.example.Alexant.Models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona p where p.nombre_persona=?1 and p.apellido_paterno=?2 and p.apellido_materno=?3 and p.ci=?4 and p.direccion=?5 and p.email=?6 and p.numero_celular=?7")
	public Persona getPersona(String nombre_persona, String apellido_paterno, String apellido_materno, String ci, String email,
			String numero_celular, String direccion );

	@Query("select p from Persona p where p.ci=?1 and p.email=?2")
	public Persona getPersonaCiEmail(String ci, String email);

	@Query("select p from Persona p where p.ci like %?1% and p.email like %?2%")
	public List<Persona> getAllPersonaCiEmail(String ci, String email);

	@Query(value = "SELECT * FROM persona p WHERE p.ci = :ci and p.estado_per !='X'", nativeQuery = true)
	public Persona getPersonaCi2(String ci);

	@Query(value = "SELECT * FROM persona p where p.email=?1 LIMIT 1", nativeQuery = true)
	public Persona getPersonaEmail2(String email);

	@Query(value = "SELECT * FROM persona AS p LEFT JOIN usuario AS u ON p.id_persona  = u.id_persona WHERE u.id_persona IS NULL;", nativeQuery = true)
	public List<Persona> listaPersonasSinUsuarios();

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD') LIMIT 1", nativeQuery = true)
    Persona buscarPorCi(String ci);

    @Query("select p from Persona p where p.estado_per != 'X'")
    public List<Persona> getListarPersonasActivas();
    

}
