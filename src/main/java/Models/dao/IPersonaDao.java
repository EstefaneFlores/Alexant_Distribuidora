package Models.dao;
import org.springframework.data.repository.CrudRepository;
import Models.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    
    /*@Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD') LIMIT 1", nativeQuery = true)
    Persona buscarPorCi(String ci);

    @Query(value = "SELECT * FROM persona WHERE id_estado IN ('A') ORDER BY id_persona ASC", nativeQuery = true)
    public List<Persona> getListarPersonasActivas();
    */
}
