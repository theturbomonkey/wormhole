CREATE DATABASE wormhole;
CREATE USER 'wormhole'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON wormhole.* TO 'wormhole'@'localhost';