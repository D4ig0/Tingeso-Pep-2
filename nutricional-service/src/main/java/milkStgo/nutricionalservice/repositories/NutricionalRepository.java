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

    @Query("select a from  NutricionalEntity  a   where a.codigo= :codigo")
    NutricionalEntity obtenerProveedor(@Param("codigo") String codigo);

    @Query("select a.grasa from NutricionalEntity a where a.codigo= :codigo")
    Double obtenerGrasa(@Param("codigo") String codigo);

    @Query("select a.solidos from NutricionalEntity a where a.codigo = :codigo")
    Double obtenerSolidos(@Param("codigo") String codigo);
}
