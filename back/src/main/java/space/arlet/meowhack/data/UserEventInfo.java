package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    private long userId;

    private long eventId;
}
