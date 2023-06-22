import { useState } from "react";
import { sampleEvents } from "shared/config";
import { Event, EventCard } from "entities/event";
import styles from "./ui.module.css";
import { PageTemplate } from "pages/template";

export const EventsPage = () => {
  const [events, setEvents] = useState<Event[]>(() => sampleEvents);

  return (
    <PageTemplate
      content={
        <div>
          <div className={styles.title}>Мероприятия</div>
          <div className={styles.events}>
            {events.map((event) => (
              <EventCard
                labelUrl={event.labelUrl}
                description={event.description}
                title={event.title}
                beItmoType={event.beItmoType}
                date={event.date}
              />
            ))}
          </div>
        </div>
      }
    />
  );
};
