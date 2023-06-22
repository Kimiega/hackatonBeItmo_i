import {BeItmo} from "shared/api/be-itmo/be-itmo-type"

export type Event = {
  labelUrl: string|null,
  title: string,
  description: string,
  date: string,
  beItmoType: BeItmo
}