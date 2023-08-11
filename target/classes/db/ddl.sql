CREATE USER IF NOT EXISTS 'zeng'@'localhost' IDENTIFIED BY 'zeng';

DROP DATABASE IF EXISTS BOOK_MVC_DB;
CREATE DATABASE BOOK_MVC_DB;
USE BOOK_MVC_DB;
GRANT ALL PRIVILEGES ON BOOK_MVC_DB.* TO 'zeng'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';
