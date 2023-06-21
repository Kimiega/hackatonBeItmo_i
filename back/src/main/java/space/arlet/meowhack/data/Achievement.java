package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.progress.ExperienceSource;
import space.arlet.meowhack.services.progress.ProgressService;

@Entity
@Table(name = "achievements")

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Achievement implements ExperienceSource {

    public enum Type {
        BUILT_IN,
        USER_CREATED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Type type;

    private String title;
    private String description;

    private int ownersCount;

    private String imageURL;

    private long exp;

    private Direction direction;

    @Override
    public long getExperience() {
        return exp;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    public static class Builder {
        private final Achievement currentAchievement;

        Builder() {
            currentAchievement = new Achievement();
        }
        public Achievement build() {
            return currentAchievement;
        }

        public Builder setTitle(String value) {
            currentAchievement.setTitle(value);
            return this;
        }

        public Builder setDescription(String value) {
            currentAchievement.setDescription(value);
            return this;
        }

        public Builder setImageUrl(String value) {
            currentAchievement.setImageURL(value);
            return this;
        }

        public Builder setDirection(Direction value) {
            currentAchievement.setDirection(value);
            return this;
        }

        public Builder setExpByTier(ProgressService.Tier tier) {
            currentAchievement.setExp(tier.exp);
            return this;
        }
    }
}
