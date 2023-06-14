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

    @Query("select a.codigoProveedor from AcopioEntity a where a.codigoProveedor =: proveedor")
    String findName(@Param("proveedor") String proveedor);

    @Query("select a from AcopioEntity a where a.codigoProveedor =: proveedor")
    List<AcopioEntity> obtenerAcopios(@Param("proveedor") String  proveedor);

    @Query("SELECT COUNT(a) FROM AcopioEntity a WHERE a.codigoProveedor = :proveedor AND LOWER(a.turno) = LOWER('M')")
    Integer cantidadTurnoM(@Param("proveedor") String proveedor);


    @Query("SELECT COUNT(a) FROM AcopioEntity a WHERE a.codigoProveedor = :proveedor AND LOWER(a.turno) = LOWER('T')")
    Integer cantidadTurnoT(@Param("proveedor") String proveedor);

    @Query("SELECT SUM(CAST(a.kls_leche AS double)) FROM AcopioEntity a WHERE a.codigoProveedor = :proveedor")
    Double totalLecheProveedor(@Param("proveedor") String proveedor);

    @Query("SELECT COUNT(DISTINCT (Date(a.fecha))) FROM AcopioEntity a WHERE a.codigoProveedor = :proveedor")
    Integer totalDiasEnviados(@Param("proveedor") String proveedor);
}
