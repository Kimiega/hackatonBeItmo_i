package space.arlet.meowhack.services;

public interface ExperienceSource {
    enum Direction {
        ECO,
        FIT,
        FRIENDLY,
        HEALTHY,
        OPEN,
        PRO
    }

    long getExperience();
    Direction getDirection();
}
