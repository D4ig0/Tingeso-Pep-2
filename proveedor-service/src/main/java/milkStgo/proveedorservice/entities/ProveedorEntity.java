package milkStgo.proveedorservice.entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "proveedores")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class ProveedorEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id_proveedor;
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;



}