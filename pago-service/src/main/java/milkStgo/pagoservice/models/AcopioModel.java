package milkStgo.pagoservice.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcopioModel{

    private Integer id_acopio;
    private String fecha;
    private String turno;
    private String codigo;
    private String kls_leche;



}
