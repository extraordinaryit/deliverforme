package extraordinaryit.apps.deliverforme.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_details", schema = "deliverforme")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User accountHolder;
}
