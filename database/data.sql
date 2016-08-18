-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Administrator', 'Anthony', 'Valentino', 'AValentino', 'xfLnHN31WrSWfK2/WtAQxQ==', 'uF0LCSU+9xXOlhgtU0rwwucCiR8PxvplbeHWqe9+1IDmztm13d06BFByExjXYG1KZKmsMPftsp3F6PIM9qZ8Kct/A6IpwhkJt361s6jJ7BIGF6DDUBZyUPIYCOxIHBEl8eSf8aC5ZP5ax8PzUYl6zQHsQ0N83SCWDsVqUQdTva0=');

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Employee', 'Callum', 'Orr', 'COrr', 'j4RJPwDy8LUjeJTvLxiGJg==', 'LsO4tIqgguAVsuhA557vFXTyFjXKiWtoDDsxW3GX3mFh+8UreHqIGmfVPkSMhSNWfDE7/DLzYCgCigu1N9t5b61oVE5tZCHay2eihOf2mFwh8kBO5i+h2QHer6BdN/U4rUWT2WFbDiHfxEvoujs8oQjC6Nc9q3X3+NSYMPbm3GM=');

INSERT INTO user_table(role, first_name, last_name, user_name, password, salt)
VALUES('Employee', 'Aaron', 'Shafron', 'AShafron', 'S0yNhgwy+2UN9vTkLxBaZQ==', 'FMtGo36D/gyxDgXJUJObZKvttktI0ytMWPTe3WcgZ7VXHOXjn3JP+pt9GC8SaRsvhpVDfxbQn2ScxLmyaiHxRWP1dmbSU3QhmdcGoKjZgRP2rN/M0Lvqv/20HDPSZVvibDt7V9eYRRvQF62gA9+46v9DWoWBw7jjnV4Tf5Urons=');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('7100', 'Euclid Ave', 'Cleveland', '44103', 'Located right outside in front of the building.');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('2401', 'Ontario St', 'Cleveland', '44115', 'N/A');

INSERT INTO location(street, city, zip, comments)
VALUES('Darrow Rd', 'Stow', '44224', 'Located between the red house and the green building.');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('230', 'W Huron Rd', 'Cleveland', '44113', 'Outside the cafe');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (1, 'Repaired', 'High', '2016-08-01', '2016-08-10', '2016-08-13');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (2, 'Repair Scheduled', 'Medium', '2016-08-02', '2016-08-12', '2016-08-15');

INSERT INTO pothole(location_id)
VALUES (3);

INSERT INTO pothole(location_id)
VALUES (4);

COMMIT;