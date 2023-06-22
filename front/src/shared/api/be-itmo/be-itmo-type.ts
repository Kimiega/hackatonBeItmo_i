export enum BeItmo {
  Fit = "be-fit",
  Pro = "be-pro",
  Friendly = "be-friendly",
  Eco = "be-eco",
  Open = "be-open",
  Healthy = "be-healthy"
}

export type BeItmoParam<BeItmo> = {
  type: BeItmo
experience: number, level: number
  max: number
}