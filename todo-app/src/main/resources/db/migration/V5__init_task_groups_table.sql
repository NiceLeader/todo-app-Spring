create table task_groups
(
    id          BIGINT primary key auto_increment,
    description varchar(255) not null,
    done        bit
);
alter table tasks add column task_group_id BIGINT null;
alter table tasks
    add foreign key (task_group_id) references task_groups (id);

