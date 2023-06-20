package space.arlet.meowhack.services.progress;

import space.arlet.meowhack.services.Direction;

public interface ExperienceSource {

    long getExperience();
    Direction getDirection();
}
