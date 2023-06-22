import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import styles from "./ui.module.css";
import biStyles from "shared/ui/styles/be-itmo-type.module.css";
import defaultBg from "shared/res/mock/background-crop.png";
import { BeItmoShield } from "shared/ui/shield";
import { Event } from "./model";

export type EventProps = Event & {
  labelUrl: string | null;
  title: string;
  description: string;
  beItmoType: BeItmo;
  date: string | null;
};

export const EventCard = ({
  labelUrl,
  title,
  beItmoType,
  description,
  date,
}: EventProps) => {
  const a = new Date(date);
  return (
    <div className={`${styles.card} ${biStyles[beItmoType]}`}>
      <div className={styles.content}>
        <div className={styles.label}>
          <img className={styles.labelImg} src={labelUrl ?? defaultBg} alt="" />
        </div>
        <div className={styles.descriptionSection}>
          <div className={styles.title}>{title}</div>
          <div>
            <BeItmoShield type={beItmoType} />
          </div>
          <div className={styles.description}>{description}</div>
          <div className={styles.date}>{a.toDateString()}</div>
        </div>
      </div>
    </div>
  );
};
