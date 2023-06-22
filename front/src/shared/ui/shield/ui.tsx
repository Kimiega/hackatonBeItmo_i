import { BeItmo } from "shared/api/be-itmo/be-itmo-type";
import beItmoStyles from "shared/ui/styles/be-itmo-type.module.css";
import styles from "./ui.module.css";

export type BeItmoShieldProps = {
  type: BeItmo;
};

export const BeItmoShield = ({ type }: BeItmoShieldProps) => {
  let label: string;
  switch (type) {
    case BeItmo.Eco:
      label = "be eco";
      break;
    case BeItmo.Fit:
      label = "be fit";
      break;
    case BeItmo.Friendly:
      label = "be freindly";
      break;
    case BeItmo.Healthy:
      label = "be healthy";
      break;
    case BeItmo.Open:
      label = "be open";
      break;
    case BeItmo.Pro:
      label = "be pro";
      break;
  }
  return (
    <div>
      <div className={`${beItmoStyles[type]} ${styles.shield}`}>{label}</div>
    </div>
  );
};
