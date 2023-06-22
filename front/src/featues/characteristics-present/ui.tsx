import { User } from "entities/user";
import styles from "./ui.module.css";
import biStyles from "shared/ui/styles/be-itmo-type.module.css";
import { Progress } from "antd";

export type UserCharacteristicsPresentParam = {
  user: User;
};

export const UserCharacteristicsPresent = ({
  user,
}: UserCharacteristicsPresentParam) => {
  let sumLevel = 0;
  Object.entries(user.beItmo).forEach(([key, value]) => {
    sumLevel += value.level;
  });
  return (
    <div className={styles.card}>
      <div className={styles.level}>
        <div className={styles.levelNumber}>{sumLevel}</div>
        <div className={styles.levelTitle}>{"Статус"}</div>
      </div>
      <div className={styles.characteristics}>
        {Object.entries(user.beItmo).map(([key, value]) => {
          return (
            <div className={styles.content}>
              <div className={`${styles.charLabel} ${biStyles[value.type]}`}>
                {key}
              </div>
              <div className={styles.barLabel}>
                <div className={styles.charLevel}>{value.level} lvl</div>
                <div className={styles.charExperience}>
                  <div className={styles.charExp}>{value.experience}/</div>
                  <div className={styles.charMax}>{value.max} xp</div>
                </div>
              </div>
              <div className={styles.charBar}>
                <Progress
                  percent={(value.experience / value.max) * 100}
                  format={(percent, successPercent) => {
                    return <>{percent?.toFixed(0) + " %"}</>;
                  }}
                />
                {/* <div
                  className={`${styles.charBarFill} ${biStyles[value.type]}`}
                ></div> */}
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};
