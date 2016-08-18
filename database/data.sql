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
VALUES('Prospect Ave', 'Cleveland', '44115', 'Located between the red house and the green building.');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('230', 'W Huron Rd', 'Cleveland', '44113', 'Outside the cafe');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('1701', 'E 12th St', 'Cleveland', '44114', 'Close to the building');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('1100', 'E 9th St', 'Cleveland', '44114', 'Outside the rock and roll hall of fame');

INSERT INTO location(street, city, zip, comments)
VALUES('St Claire Ave NE and E 26th St', 'Cleveland', '44114', 'At the intersection');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('2900', 'Community College Ave', 'Cleveland', '44115', 'Outside the campus');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('2900', 'Community College Ave', 'Cleveland', '44115', 'Close to the campus');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('10900', 'Euclid Ave', 'Cleveland', '44106', 'N/A');

INSERT INTO location(street, city, zip, comments)
VALUES('Superior Ave and E 79th St', 'Cleveland', '44103', 'At the intersection');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('1979', 'W 25th St', 'Cleveland', '44113', 'Outside the market');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('3820', 'Superior Ave', 'Cleveland', '44114', 'Near the lightpole');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('2100', 'Lakeside Ave E', 'Cleveland', '44114', 'N/A');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('8800', 'Euclid Ave', 'Cleveland', '44106', 'Outside the hotel');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('1790', 'Columbus Rd', 'Cleveland', '44113', 'Outside of the Lolly the Trolley');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('650', 'Harrison St', 'Cleveland', '44113', 'N/A');

INSERT INTO location(address_number, street, city, zip, comments)
VALUES('1114', 'Center St', 'Cleveland', '44113', 'Outside the cafe');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (1, 'Repaired', 'High', '2016-07-01', '2016-07-10', '2016-07-13');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (2, 'Repaired', 'Medium', '2016-07-02', '2016-07-12', '2016-07-15');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (3, 'Repaired', 'Medium', '2016-07-02', '2016-07-13', '2016-07-18');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (4, 'Repaired', 'Low', '2016-07-05', '2016-07-18', '2016-07-25');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (5, 'Repaired', 'High', '2016-07-07', '2016-07-20', '2016-07-27');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (6, 'Repaired', 'High', '2016-07-10', '2016-07-22', '2016-07-29');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (7, 'Repaired', 'Low', '2016-07-15', '2016-07-26', '2016-08-01');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (8, 'Repaired', 'Medium', '2016-07-21', '2016-07-28', '2016-08-05');

INSERT INTO pothole(location_id, status, create_date, inspection_date)
VALUES (9, 'Duplicate', '2016-07-23', '2016-07-29');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (10, 'Repaired', 'Medium', '2016-07-29', '2016-08-08', '2016-08-15');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (11, 'Repaired', 'High', '2016-08-05', '2016-08-13', '2016-08-16');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (12, 'Repaired', 'Low', '2016-08-07', '2016-08-14', '2016-08-17');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (13, 'Repair Scheduled', 'Medium', '2016-08-09', '2016-08-16', '2016-08-26');

INSERT INTO pothole(location_id, status, priority_level, create_date, inspection_date, fixed_date)
VALUES (14, 'Repair Scheduled', 'Low', '2016-08-09', '2016-08-17', '2016-08-27');

INSERT INTO pothole(location_id, status, create_date, inspection_date)
VALUES (15, 'Inspection Scheduled', '2016-08-13', '2016-08-22');

INSERT INTO pothole(location_id, status, create_date, inspection_date)
VALUES (16, 'Inspection Scheduled', '2016-08-15', '2016-08-25');

INSERT INTO pothole(location_id, create_date)
VALUES (17, '2016-08-15');

INSERT INTO pothole(location_id, create_date)
VALUES (18, '2016-08-16');

COMMIT;