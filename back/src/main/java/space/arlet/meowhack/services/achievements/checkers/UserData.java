package space.arlet.meowhack.services.achievements.checkers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.data.EventInfo;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserData {
    private long userId;
    private List<Long> trafficInfo;
    private List<EventInfo> eventInfo;
    private long course;
    // site stats
    // level info
}
