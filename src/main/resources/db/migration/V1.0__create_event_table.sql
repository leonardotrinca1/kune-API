create table event (
    id serial,
    event_name varchar(50) not null,
    event_date date not null,
    address varchar(75) not null,
    description varchar(100) not null,
    constraint pk_event primary key(id),
    constraint un_id unique(id)

);