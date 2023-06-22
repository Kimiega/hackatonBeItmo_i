import { BeItmo } from "shared/api/be-itmo/be-itmo-type";

export type BeItmoIconProps = {
  type: BeItmo;
};

export const BeItmoIcon = ({ type }: BeItmoIconProps) => {
  let iconUrl;
  switch (type) {
    case BeItmo.Eco:
      iconUrl = "";
      break;
    case BeItmo.Fit:
      iconUrl = "";
      break;
    case BeItmo.Freindly:
      iconUrl = "";
      break;
    case BeItmo.Healthy:
      iconUrl = "";
      break;
    case BeItmo.Open:
      iconUrl = "";
      break;
    case BeItmo.Pro:
      iconUrl = "";
      break;
  }

  return <img src={iconUrl} alt="" />;
};
