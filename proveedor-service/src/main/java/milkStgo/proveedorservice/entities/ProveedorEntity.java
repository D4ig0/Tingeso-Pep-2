package milkStgo.proveedorservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


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

    private int id_proveedor;
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;



}