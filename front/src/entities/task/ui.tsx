import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import biStyle from "shared/ui/styles/be-itmo-type.module.css";
import styles from "./ui.module.css";
import { BeItmoIcon } from "shared/ui/be-itmo-icon";
import { DateTime } from "shared/api/date/date";
import { Task } from "./model";

export type TaskCardProps = Task & {
  title: string;
  date: string | null;
  description: string;
  experiense: number;
  beItmoType: BeItmo;
};

export const TaskCard = ({
  title,
  date,
  description,
  experiense,
  beItmoType,
}: TaskCardProps) => {
  return (
    <div className={styles.container}>
      {/* <div className={`${styles.icon} ${biStyle[beItmoType]}`}>
        <BeItmoIcon type={beItmoType} />
      </div> */}
      <div className={`${biStyle[beItmoType]} ${styles.card}`}>
        <div className={styles.content}>
          {/* <div className={styles.section}>
            <div className={styles.title}>{title}</div>
            <div className={styles.date}>{date ?? ""}</div>
          </div> */}
          <div className={styles.section}>
            <div className={styles.description}>{description}</div>
          </div>
          <div className={styles.section}>
            <div className={styles.experience}>{experiense}xp</div>
          </div>
        </div>
      </div>
    </div>
  );
};
