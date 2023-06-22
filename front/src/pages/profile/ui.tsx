import { UserCharacteristicsPresent } from "featues/characteristics-present";
import { Task } from "entities/task";
import { Event } from "entities/event";
import { TaskList } from "widgets/task-list";
import { EventsList } from "widgets/event-list";
import { useEffect, useState } from "react";
import { User } from "entities/user";
import {
  testListAchievements,
  testListTasks,
  testUser,
} from "pages/test/model";
import styles from "./ui.module.css";
import { AchieventsPanel } from "widgets/achievements-panel";
import { Achievement } from "entities/achievment";

export const ProfilePage = () => {
  const [user, setUser] = useState<User>(() => testUser);
  const [tasks, setTasks] = useState<Task[]>(() => testListTasks);
  const [achievements, setAchievements] = useState<Achievement[]>(
    () => testListAchievements
  );
  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    (async () => {
      return;
    })();
  }, []);

  return (
    <div>
      <div className={styles.title}>Мой профиль</div>
      <div className={styles.page}>
        <div className={styles.userChar}>
          <UserCharacteristicsPresent user={user} />
        </div>
        <div className={styles.tasksContainer}>
          <div className={styles.tasks}>
            <TaskList tasks={tasks} />
          </div>
        </div>
        <div className={styles.achievments}>
          <AchieventsPanel achievements={achievements} />
        </div>
      </div>
    </div>
  );
};
