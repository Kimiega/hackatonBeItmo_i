package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_events")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEventInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long userId;

    private long eventId;
}
