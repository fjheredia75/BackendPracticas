CREATE TABLE IF NOT EXISTS category(
id SERIAL,
description VARCHAR(100) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS customer(
id SERIAL,
firstname VARCHAR (100) NULL,
lastname VARCHAR(100) NOT NULL,
nui VARCHAR (100) NOT NULL,
email VARCHAR(100) NOT NULL,
phone VARCHAR(100) NOT NULL,
age INT NOT NULL,
PRIMARY KEY (id),
category_id INT NOT NULL,
FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS oportunity(
id SERIAL,
description VARCHAR(100) NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_fin DATE NOT NULL,
PRIMARY KEY (id),
customer_id INT NOT NULL,
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS activity(
id SERIAL,
description VARCHAR(100) NOT NULL,
fecha DATE NOT NULL,
PRIMARY KEY (id),
oportunity_id INT NOT NULL,
FOREIGN KEY (oportunity_id) REFERENCES oportunity(id)
);