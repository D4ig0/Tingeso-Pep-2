package milkStgo.pagoservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutricionalModel {

    private Integer id_nutricional;
    private String  codigoProveedor;
    private Integer grasa;
    private Integer solidos_totales;

}