package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long id;

    private String name;
    private String description;

    private ZonedDateTime startTime;
    private ZonedDateTime finishTime;

    private String direction;
}
