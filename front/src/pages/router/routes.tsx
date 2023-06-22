import { RouteObject } from "react-router-dom";
import { paths } from "./paths";
import { TestPage } from "pages/test/ui";
import { ProfilePage } from "pages/profile";
import { EventsPage } from "pages/events";

export const publicRoutes: RouteObject[] = [
  {
    path: paths.TEST,
    element: <TestPage />,
  },
  {
    path: paths.PROFILE,
    element: <ProfilePage />,
  },
  {
    path: paths.EVENTS,
    element: <EventsPage />,
  },
];
