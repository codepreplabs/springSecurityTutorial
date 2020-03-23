create table users
(
	  id bigint not null primary key,
      username varchar_ignorecase(50),
      password varchar_ignorecase(50) not null,
      roles varchar_ignorecase(100) not null,
      enabled boolean not null
);