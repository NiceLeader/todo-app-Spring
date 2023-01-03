drop table if exists tasks;
create table tasks (
  id BIGINT primary key auto_increment,
  description varchar(255) not null,
  done bit
)