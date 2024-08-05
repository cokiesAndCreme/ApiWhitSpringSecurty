CREATE TABLE user(
id_user INT NOT NULL AUTO_INCREMENT,
name_user VARCHAR(120) NOT NULL,
phone_user VARCHAR(12) NOT NULL,
direccion_user VARCHAR(200),
PRIMARY KEY(id_user)
);

CREATE TABLE dates(
id_date INT NOT NULL AUTO_INCREMENT,
service_date VARCHAR(10) NOT NULL,
payment_status_date VARCHAR(20) NOT NULL,
day_of_date DATE NOT NULL,
hour_of_date TIME NOT NULL,
creation_date VARCHAR(20) NOT NULL,
user_dates INT NOT NULL,
PRIMARY KEY(id_date),
FOREIGN KEY (user_dates) REFERENCES user(id_user)
);
