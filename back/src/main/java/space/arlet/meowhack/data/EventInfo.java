package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.services.Direction;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity
@Table(name="events_info")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    private ZonedDateTime startTime;
    private ZonedDateTime finishTime;

    private Direction direction;
}
