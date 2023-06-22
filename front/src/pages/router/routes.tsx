import { RouteObject } from "react-router-dom";
import { paths } from "./paths";
import { CounterPage } from "../counter";
import { TestPage } from "pages/test/ui";
import { ProfilePage } from "pages/profile";

export const publicRoutes: RouteObject[] = [
  {
    path: paths.COUNTER,
    element: <CounterPage />,
  },
  {
    path: paths.TEST,
    element: <TestPage />,
  },
  {
    path: paths.PROFILE,
    element: <ProfilePage />,
  },
];
