package milkStgo.pagoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutricionalModel {

    private Integer id_nutricional;
    private String  codigo;
    private Integer grasa;
    private Integer solidos_totales;

}