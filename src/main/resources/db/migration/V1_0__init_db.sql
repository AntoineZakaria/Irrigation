CREATE TABLE plot (
  id INT AUTO_INCREMENT NOT NULL,
   area DOUBLE NULL,
   CONSTRAINT pk_plot PRIMARY KEY (id)
);

CREATE TABLE irrigation_time_slot (
  id INT AUTO_INCREMENT NOT NULL,
   start_time time NULL,
   end_time time NULL,
   CONSTRAINT pk_irrigation_time_slot PRIMARY KEY (id)
);

CREATE TABLE plot_timeslot (
  id INT AUTO_INCREMENT NOT NULL,
   irrigation_timeslot_id INT NULL,
   plot_id INT NULL,
   water_amount DOUBLE NULL,
   CONSTRAINT pk_plot_timeslot PRIMARY KEY (id)
);

ALTER TABLE plot_timeslot ADD CONSTRAINT FK_IRRIGATION_ON_PLOT_TIMESLOT FOREIGN KEY (irrigation_timeslot_id) REFERENCES irrigation_time_slot (id);
ALTER TABLE plot_timeslot ADD CONSTRAINT FK_PLOT_ON_PLOT_TIMESLOT FOREIGN KEY (plot_id) REFERENCES plot (id);

