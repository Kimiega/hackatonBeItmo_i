import { AchievmentCard } from "entities/achievment";
import { EventCard } from "entities/event";
import { TaskCard } from "entities/task";
import { User } from "entities/user";
import { UserCharacteristicsPresent } from "featues/characteristics-present";
import { BeItmo, BeItmoParam } from "shared/api/be-itmo/be-itmo-type";
import { DateTime } from "shared/api/date/date";

export const TestPage = () => {
  return (
    <div>
      <AchievmentCard
        labelUrl={null}
        title="Kek"
        experience={10}
        description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"
        beItmoType={BeItmo.Eco}
      />
      <EventCard
        labelUrl={null}
        title="Lol"
        description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"
        beItmoType={BeItmo.Freindly}
      />

      <TaskCard
        title="Idklolkek"
        description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim "
        date={{ time: "00.00.2023" } as DateTime}
        experiense={30}
        beItmoType={BeItmo.Open}
      />

      <UserCharacteristicsPresent
        user={
          {
            beItmo: {
              eco: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Eco,
              } as BeItmoParam<BeItmo.Eco>,
              fit: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Fit,
              } as BeItmoParam<BeItmo.Fit>,
              friendly: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Freindly,
              } as BeItmoParam<BeItmo.Freindly>,
              healthy: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Healthy,
              } as BeItmoParam<BeItmo.Healthy>,
              open: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Open,
              } as BeItmoParam<BeItmo.Open>,
              pro: {
                experience: 10,
                level: 10,
                max: 30,
                type: BeItmo.Pro,
              } as BeItmoParam<BeItmo.Pro>,
            },
          } as User
        }
      />
    </div>
  );
};
