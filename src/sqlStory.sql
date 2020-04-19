create schema newspost;
set search_path to newspost;
create table postdata (id bigserial, head text, article text);

set search_path to newspost;
create table users (username varchar(50) primary key,
					password varchar(100) not null,
				   enabled boolean not null);

create table authorities (username varchar(50) not null,
					authority varchar(50) not null,
					foreign key(username) references
					 users(username));

insert into users (username, password, enabled)
values ('Bob', '{noop}1234', true);

insert into authorities (username, authority)
values ('Bob', 'ROLE_ADMIN');