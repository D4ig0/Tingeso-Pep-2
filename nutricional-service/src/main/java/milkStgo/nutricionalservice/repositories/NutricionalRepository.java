package milkStgo.nutricionalservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import milkStgo.nutricionalservice.entities.NutricionalEntity;

import java.util.ArrayList;

@Repository
public interface NutricionalRepository extends JpaRepository<NutricionalEntity, Integer> {

    @Query("select a from NutricionalEntity a")
    ArrayList<NutricionalEntity> findAll();

    @Query("select a.proveedor from  NutricionalEntity  a   where a.proveedor=: proveedor")
    String obtenerProveedor(@Param("proveedor") String proveedor);

    @Query("select a.grasa from NutricionalEntity a where a.proveedor= :proveedor")
    Double obtenerGrasa(@Param("proveedor") String proveedor);

    @Query("select a.solidos_totales from NutricionalEntity a where a.proveedor = :proveedor")
    Double obtenerSolidos(@Param("proveedor") String proveedor);
}
