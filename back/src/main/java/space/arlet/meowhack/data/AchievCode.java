package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "achiev_codes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievCode {
    @Id
    private long id;

    private String code;
    private long achievId;
}
