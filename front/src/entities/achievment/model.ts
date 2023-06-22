import {BeItmo} from "shared/api/be-itmo/be-itmo-type";

export type Achievement = {
  labelUrl: string|null; title : string; description : string;
  experience : number;
  beItmoType : BeItmo;
}