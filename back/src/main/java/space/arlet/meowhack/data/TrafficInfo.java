package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name="traffic_info")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrafficInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private ZonedDateTime enterTime;
    private ZonedDateTime exitTime;

    private String building;
    private String auditory;
}
