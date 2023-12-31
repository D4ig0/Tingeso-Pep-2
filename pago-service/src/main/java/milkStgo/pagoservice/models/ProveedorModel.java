package milkStgo.pagoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorModel {
    private int id_proveedor;
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;
}