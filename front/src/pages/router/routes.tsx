import { RouteObject } from "react-router-dom";
import { paths } from "./paths";
import { CounterPage } from "../counter";
import { TestPage } from "pages/test/ui";

export const publicRoutes: RouteObject[] = [
  {
    path: paths.COUNTER,
    element: <CounterPage />,
  },
  {
    path: paths.TEST,
    element: <TestPage />,
  },
];
