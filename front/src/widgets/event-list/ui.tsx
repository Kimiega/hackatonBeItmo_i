import { Event, EventCard } from "entities/event";
import styles from "./ui.module.css";

export type EventListProps = {
  events: Event[];
};

export const EventsList = ({ events }: EventListProps) => {
  const elements = events.map((event) => {
    return (
      <EventCard
        labelUrl={event.labelUrl}
        title={event.title}
        beItmoType={event.beItmoType}
        description={event.description}
        date={event.date}
      />
    );
  });
  return <div className={styles.list}>{elements}</div>;
};
