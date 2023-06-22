import { AchievmentCard } from "entities/achievment";
import { EventCard } from "entities/event";
import { TaskCard } from "entities/task";
import { UserCharacteristicsPresent } from "featues/characteristics-present";
import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import { testEvent, testListTasks, testTask, testUser } from "./model";
import { TaskList } from "widgets/task-list";

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
        title={"Lol"}
        description={
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"
        }
        beItmoType={BeItmo.Friendly}
        date={"01/02/03"}
      />

      <TaskCard
        title={testTask.title}
        description={testTask.description}
        date={testTask.date}
        experiense={testTask.experiense}
        beItmoType={testTask.beItmoType}
      />

      <UserCharacteristicsPresent user={testUser} />

      <EventCard
        labelUrl={testEvent.labelUrl}
        title={testEvent.title}
        description={testEvent.description}
        beItmoType={testEvent.beItmoType}
        date={testEvent.date}
      />

      {/* <EventList events={testListEvents} /> */}
      <TaskList tasks={testListTasks} />
    </div>
  );
};
