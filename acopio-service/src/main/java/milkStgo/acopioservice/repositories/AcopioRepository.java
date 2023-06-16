package milkStgo.acopioservice.repositories;

import milkStgo.acopioservice.entities.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AcopioRepository extends JpaRepository <AcopioEntity, Integer>{

    @Query("select a from AcopioEntity a")
    List<AcopioEntity> findAll();


    @Query("SELECT a FROM AcopioEntity a WHERE a.codigo = :codigo")
    List<AcopioEntity> obtenerAcopios(@Param("codigo") String codigo);


    @Query("SELECT COUNT(a) FROM AcopioEntity a WHERE a.codigo = :codigo AND LOWER(a.turno) = LOWER('M')")
    Integer cantidadTurnoM(@Param("codigo") String codigo);


    @Query("SELECT COUNT(a) FROM AcopioEntity a WHERE a.codigo = :codigo AND LOWER(a.turno) = LOWER('T')")
    Integer cantidadTurnoT(@Param("codigo") String codigo);

    @Query("SELECT SUM(CAST(a.kls_leche AS double)) FROM AcopioEntity a WHERE a.codigo = :codigo")
    Double totalLecheProveedor(@Param("codigo") String codigo);

    @Query("SELECT COUNT(DISTINCT (Date(a.fecha))) FROM AcopioEntity a WHERE a.codigo = :codigo")
    Integer totalDiasEnviados(@Param("codigo") String codigo);
}
