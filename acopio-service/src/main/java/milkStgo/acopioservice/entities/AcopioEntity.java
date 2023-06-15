package milkStgo.acopioservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "acopios")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class AcopioEntity{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id_acopio;
    private String fecha;
    private String turno;
    private String codigoProveedor;
    private String kls_leche;



}
