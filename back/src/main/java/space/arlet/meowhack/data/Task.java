package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.services.Direction;

@Entity
@Table(name = "tasks")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private Direction direction;
    private long exp;
}
