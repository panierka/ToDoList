create table task(
  id SERIAL PRIMARY KEY,
  "content" VARCHAR(255),
  is_completed BOOLEAN DEFAULT FALSE,
  description VARCHAR(255),
  deadline timestamp,
  "order" INT NOT NULL
);

insert into task ("content", is_completed, "order") VALUES
                                             ('a', false, 3),
                                             ('b', false, 1),
                                             ('c', true, 2);

