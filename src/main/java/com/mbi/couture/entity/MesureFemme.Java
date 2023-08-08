@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MesureFemme")
public class MesureFemme extends Mesure{
    private Float dessousPoit;
    private Float cretesIliaque;
    private Float LDos;

}