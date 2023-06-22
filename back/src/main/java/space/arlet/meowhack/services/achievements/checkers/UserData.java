package space.arlet.meowhack.services.achievements.checkers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.data.TrafficInfo;
import space.arlet.meowhack.data.UserEventInfo;
import space.arlet.meowhack.services.Direction;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserData {
    private long userId;
    private List<TrafficInfo> trafficInfos;
    private List<UserEventInfo> userEventInfos;
    private long course;
    // site stats
    private Map<Direction, Long> levelInfo;
}
