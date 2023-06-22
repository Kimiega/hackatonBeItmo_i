import { BeItmo } from "shared/api/be-itmo/be-itmo-type";

export type Task = {
  title: string;
  date: string | null;
  description: string;
  experiense: number;
  beItmoType: BeItmo;
}