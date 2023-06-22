import {Event} from "entities/event";
import {Task} from "entities/task";
import {User} from "entities/user";
import {BeItmo, BeItmoParam} from "shared/api/be-itmo/be-itmo-type";

export const testEvent = {
  labelUrl : null,
  title : "kasdfasdfas",
  description : "asdfasdfasdfasd",
  beItmoType : BeItmo.Eco,
  date : "01/02/03",
} as Event;
export const testListEvents = new Array(10).fill(0).map(() => testEvent)

export const testUser = {
  beItmo : {
    eco : {
      experience : 20,
      level : 10,
      max : 500,
      type : BeItmo.Eco,
    } as BeItmoParam<BeItmo.Eco>,
    fit : {
      experience : 3,
      level : 10,
      max : 320,
      type : BeItmo.Fit,
    } as BeItmoParam<BeItmo.Fit>,
    friendly : {
      experience : 190,
      level : 10,
      max : 600,
      type : BeItmo.Friendly,
    } as BeItmoParam<BeItmo.Friendly>,
    healthy : {
      experience : 100,
      level : 10,
      max : 400,
      type : BeItmo.Healthy,
    } as BeItmoParam<BeItmo.Healthy>,
    open : {
      experience : 10,
      level : 7,
      max : 309,
      type : BeItmo.Open,
    } as BeItmoParam<BeItmo.Open>,
    pro : {
      experience : 10,
      level : 11,
      max : 30,
      type : BeItmo.Pro,
    } as BeItmoParam<BeItmo.Pro>,
  },
} as User

export const testTask = {
  title : "Idklolkek",
  description :
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ",
  date : "01/02/03",
  experiense : 30,
  beItmoType : BeItmo.Open,
} as Task
export const testListTasks = new Array(10).fill(0).map(() => testTask)

export const testAchievement = {
  labelUrl : null,
  title : "Kek",
  experience : 10,
  description :
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
  beItmoType : BeItmo.Eco,
};
export const testListAchievements =
    new Array(10).fill(0).map(() => testAchievement)
