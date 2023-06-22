package space.arlet.meowhack.services.achievements.checkers.impls;

import space.arlet.meowhack.services.achievements.checkers.Checker;
import space.arlet.meowhack.services.achievements.checkers.UserData;

public class TestChecker implements Checker {

    @Override
    public long getId() {
        return -1;
    }

    @Override
    public boolean isReceived(UserData userData) {
        return false;
    }
}
