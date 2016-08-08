-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE TABLE user_table (
	user_id serial NOT NULL,
	role varchar(64) NOT NULL,
	first_name varchar(64) NOT NULL,
	last_name varchar(64) NOT NULL,
	user_name varchar(32) NOT NULL,
	password varchar(32) NOT NULL,
	salt varchar(256) NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY (user_id)
);

CREATE TABLE location (
	location_id serial NOT NULL,
	street_address varchar(64) NOT NULL,
	city varchar(64) NOT NULL,
	state varchar(2) NOT NULL,
	zip varchar(12) NOT NULL,
	comments varchar(300),
	CONSTRAINT pk_location_id PRIMARY KEY (location_id)
);

CREATE TABLE pothole (
	pothole_id serial NOT NULL,
	location_id integer NOT NULL,
	is_scheduled boolean NOT NULL DEFAULT FALSE,
	does_not_exist boolean NOT NULL DEFAULT FALSE,
	has_been_visited boolean NOT NULL DEFAULT FALSE,
	is_duplicate boolean NOT NULL DEFAULT FALSE,
	is_fixed boolean NOT NULL DEFAULT FALSE,
	priority_level varchar(32),
	create_date date NOT NULL DEFAULT now(),
	inspection_date date,
	fixed_date date,
	CONSTRAINT pk_pothole_id PRIMARY KEY (pothole_id),
	FOREIGN KEY (location_id) REFERENCES location(location_id)
);

COMMIT;