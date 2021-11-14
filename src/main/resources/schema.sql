Create TABLE IF NOT EXISTS project(
    id SERIAL,
    name VARCHAR(50),
    description varchar (1000),
    email varchar (50),
    isvalidated BOOLEAN,
    primary key (id,name)
);