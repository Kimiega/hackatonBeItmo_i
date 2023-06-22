import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import defaultBg from "shared/res/mock/background-crop.png";
import { BeItmoShield } from "shared/ui/shield";
import styles from "./ui.module.css";
import beItmoStyles from "shared/ui/styles/be-itmo-type.module.css";

export type EventProps = {
  labelUrl: string | null;
  title: string;
  description: string;
  beItmoType: BeItmo;
};

export const EventCard = ({
  labelUrl,
  title,
  beItmoType,
  description,
}: EventProps) => {
  return (
    <div className={`${styles.card} ${beItmoStyles[beItmoType]}`}>
      <div className={styles.content}>
        <div className={styles.label}>
          <img className={styles.labelImg} src={labelUrl ?? defaultBg} alt="" />
        </div>
        <div className={styles.contentDescription}>
          <div className={styles.title}>{title}</div>
          <div>
            <BeItmoShield type={beItmoType} />
          </div>
          <div className={styles.description}>{description}</div>
        </div>
      </div>
    </div>
  );
};
