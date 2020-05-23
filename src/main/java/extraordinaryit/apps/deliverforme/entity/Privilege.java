package extraordinaryit.apps.deliverforme.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "privilege", schema = "deliverforme")
public class Privilege {

    @Id
    @SequenceGenerator(name="SQC_Privilege_id", allocationSize = 1, sequenceName = "sqc_custom")
    @GeneratedValue(generator = "SQC_Privilege_id")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

}