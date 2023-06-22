import {BeItmo, BeItmoParam} from "shared/api/be-itmo/be-itmo-type"

export type User = {
  beItmo: {
    eco: BeItmoParam<BeItmo.Eco>,
    fit: BeItmoParam<BeItmo.Fit>,
    friendly: BeItmoParam<BeItmo.Friendly>,
    healthy: BeItmoParam<BeItmo.Healthy>,
    open: BeItmoParam<BeItmo.Open>,
    pro: BeItmoParam<BeItmo.Pro>,
  }
}