-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Administrator', 'Anthony', 'Valentino', 'AValentino', 'password', 'pepper');

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Employee', 'Callum', 'Orr', 'COrr', 'callum', '$12ffsdf');

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Employee', 'Aaron', 'Shafron', 'AShafron', 'aaron', 'gitpush');

INSERT INTO location(street_address, city, state, zip, comments)
VALUES('7100 Euclid Ave', 'Cleveland', 'OH', '44103', 'Located right outside in front of the building.');

INSERT INTO location(street_address, city, state, zip)
VALUES('123 Smith Rd', 'Brunswick', 'OH', '44212');

INSERT INTO location(street_address, city, state, zip, comments)
VALUES('Main St', 'Stow', 'OH', '44224', 'Located between the red house and the green building.');

INSERT INTO pothole(location_id)
VALUES (1);

INSERT INTO pothole(location_id)
VALUES (2);

INSERT INTO pothole(location_id)
VALUES (3);

COMMIT;