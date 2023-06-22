import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import styles from "./ui.module.css";
import beItmoStyles from "shared/ui/styles/be-itmo-type.module.css";
import defaultBg from "shared/res/mock/background-crop.png";
import { Achievement } from "./model";

export type AchievementProps = {
  labelUrl: string | null;
  title: string;
  description: string;
  experience: number;
  beItmoType: BeItmo;
} & Achievement;

export const AchievmentCard = ({
  labelUrl,
  title,
  description,
  experience,
  beItmoType,
}: AchievementProps) => {
  return (
    <div className={`${styles.card} ${beItmoStyles[beItmoType]}`}>
      <div className={styles.content}>
        <div className={styles.label}>
          <img className={styles.labelImg} src={labelUrl ?? defaultBg} alt="" />
        </div>
        <div className={styles.title}>{title}</div>
        <div className={styles.description}>{description}</div>
        <div className={styles.experience}>{experience} px</div>
      </div>
    </div>
  );
};
