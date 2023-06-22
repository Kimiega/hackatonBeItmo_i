import { Achievement, AchievmentCard } from "entities/achievment";
import styles from "./ui.module.css";

export type AchieventsPanelProps = {
  achievements: Achievement[];
};

export const AchieventsPanel = ({ achievements }: AchieventsPanelProps) => {
  const elements = achievements.map((ach) => (
    <AchievmentCard
      labelUrl={ach.labelUrl}
      description={ach.description}
      title={ach.title}
      experience={ach.experience}
      beItmoType={ach.beItmoType}
    />
  ));
  return <div className={styles.panel}>{elements}</div>;
};
