import { TaskCard } from "entities/task";
import { Task } from "entities/task";
import styles from "./ui.module.css";

export type TasksListProps = {
  tasks: Task[];
};

export const TaskList = ({ tasks }: TasksListProps) => {
  const elements = tasks.map((task) => {
    return (
      <TaskCard
        title={task.title}
        beItmoType={task.beItmoType}
        description={task.description}
        date={task.date}
        experiense={task.experiense}
      />
    );
  });
  return <div className={styles.list}>{elements}</div>;
};
