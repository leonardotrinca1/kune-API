alter table event add column categories_id int not null;
alter table event
    add constraint fk_event_categories
    foreign key (categories_id) references categories (id);