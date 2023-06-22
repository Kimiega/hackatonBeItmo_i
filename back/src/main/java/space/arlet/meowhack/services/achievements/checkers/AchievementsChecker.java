package space.arlet.meowhack.services.achievements.checkers;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AchievementsChecker {
    private final List<Checker> checkers = new ArrayList<>();

    public AchievementsChecker() {
        createCheckers();
    }

    public List<Checker> getCheckers() {
        return checkers;
    }

    private void createCheckers() {
        List<Class<?>> classes = getAnnotatedClasses();

        classes.forEach((checkerClass) -> {
            if (checkerClass == Checker.class)
                return;
            try {
                checkers.add((Checker) checkerClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e); // ignored (only compilation purpose)
            }
        });
    }

    private List<Class<?>> getAnnotatedClasses() {
        Reflections reflections = new Reflections(this.getClass().getPackage().getName());
        return new ArrayList<>(reflections.getTypesAnnotatedWith(Achievement.class));
    }
}
