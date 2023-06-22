package space.arlet.meowhack.services.achievements.checkers;

@Achievement
public interface Checker {
    long getId();
    boolean isReceived(UserData userData);
}
