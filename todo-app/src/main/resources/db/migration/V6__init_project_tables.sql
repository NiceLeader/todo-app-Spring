create table projects
(
    id          BIGINT primary key auto_increment,
    description varchar(255) not null
);
create table project_steps(
    id          BIGINT primary key auto_increment,
    description varchar(255) not null,
    days_to_deadline int not null,
    project_id  BIGINT not null,
    foreign key (project_id) references projects(id)
);
alter table task_groups
    add column project_id BIGINT null;
alter table task_groups
    add foreign key (project_id) references projects (id);

