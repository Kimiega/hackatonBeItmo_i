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

    public static class Builder {
        private final Task currentTask;

        public Builder() {
            currentTask = new Task();
        }

        public Builder setDescription(String value) {
            this.currentTask.setDescription(value);
            return this;
        }

        public Builder setDirection(Direction direction) {
            this.currentTask.setDirection(direction);
            return this;
        }

        public Builder setExp(long exp) {
            this.currentTask.setExp(exp);
            return this;
        }
    }
}
