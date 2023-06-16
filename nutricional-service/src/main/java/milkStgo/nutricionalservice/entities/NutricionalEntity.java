package milkStgo.nutricionalservice.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "nutricionales")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class NutricionalEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id_nutricional;
    private String  codigo;
    private Integer grasa;
    private Double solidos;

}



