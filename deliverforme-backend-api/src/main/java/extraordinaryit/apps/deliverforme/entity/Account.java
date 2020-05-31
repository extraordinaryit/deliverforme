package extraordinaryit.apps.deliverforme.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account", schema = "deliverforme")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double accumulatedBalance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User accountHolder;

}
