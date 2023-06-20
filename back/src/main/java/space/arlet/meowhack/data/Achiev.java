package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "user_achievements")

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Achiev {
    @Id
    private long id;

    private String title;
    private String description;

    private float receivingPercent;

    private ZonedDateTime date;

    private String imageURL;
}
