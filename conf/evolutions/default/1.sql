# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actor (
  actor_id                      integer auto_increment not null,
  name                          varchar(255),
  constraint pk_actor primary key (actor_id)
);

create table actor_dvd (
  actor_actor_id                integer not null,
  dvd_isbn                      varchar(255) not null,
  constraint pk_actor_dvd primary key (actor_actor_id,dvd_isbn)
);

create table author (
  author_id                     integer auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (author_id)
);

create table author_book (
  author_author_id              integer not null,
  book_isbn                     varchar(255) not null,
  constraint pk_author_book primary key (author_author_id,book_isbn)
);

create table book (
  isbn                          varchar(255) not null,
  title                         varchar(255),
  sector                        varchar(255),
  publication_date              datetime(6),
  borrowed_date_time            varchar(255),
  current_reader_reader_id      varchar(255),
  status                        varchar(255),
  publisher                     varchar(255),
  num_of_pages                  integer not null,
  constraint pk_book primary key (isbn)
);

create table dvd (
  isbn                          varchar(255) not null,
  title                         varchar(255),
  sector                        varchar(255),
  publication_date              datetime(6),
  borrowed_date_time            varchar(255),
  current_reader_reader_id      varchar(255),
  status                        varchar(255),
  languages                     varchar(1000),
  subtitles                     varchar(1000),
  producer                      varchar(255),
  constraint pk_dvd primary key (isbn)
);

create table reader (
  reader_id                     varchar(255) not null,
  name                          varchar(255),
  email                         varchar(255),
  phone_number                  varchar(255),
  constraint pk_reader primary key (reader_id)
);

create index ix_actor_dvd_actor on actor_dvd (actor_actor_id);
alter table actor_dvd add constraint fk_actor_dvd_actor foreign key (actor_actor_id) references actor (actor_id) on delete restrict on update restrict;

create index ix_actor_dvd_dvd on actor_dvd (dvd_isbn);
alter table actor_dvd add constraint fk_actor_dvd_dvd foreign key (dvd_isbn) references dvd (isbn) on delete restrict on update restrict;

create index ix_author_book_author on author_book (author_author_id);
alter table author_book add constraint fk_author_book_author foreign key (author_author_id) references author (author_id) on delete restrict on update restrict;

create index ix_author_book_book on author_book (book_isbn);
alter table author_book add constraint fk_author_book_book foreign key (book_isbn) references book (isbn) on delete restrict on update restrict;

create index ix_book_current_reader_reader_id on book (current_reader_reader_id);
alter table book add constraint fk_book_current_reader_reader_id foreign key (current_reader_reader_id) references reader (reader_id) on delete restrict on update restrict;

create index ix_dvd_current_reader_reader_id on dvd (current_reader_reader_id);
alter table dvd add constraint fk_dvd_current_reader_reader_id foreign key (current_reader_reader_id) references reader (reader_id) on delete restrict on update restrict;


# --- !Downs

alter table actor_dvd drop foreign key fk_actor_dvd_actor;
drop index ix_actor_dvd_actor on actor_dvd;

alter table actor_dvd drop foreign key fk_actor_dvd_dvd;
drop index ix_actor_dvd_dvd on actor_dvd;

alter table author_book drop foreign key fk_author_book_author;
drop index ix_author_book_author on author_book;

alter table author_book drop foreign key fk_author_book_book;
drop index ix_author_book_book on author_book;

alter table book drop foreign key fk_book_current_reader_reader_id;
drop index ix_book_current_reader_reader_id on book;

alter table dvd drop foreign key fk_dvd_current_reader_reader_id;
drop index ix_dvd_current_reader_reader_id on dvd;

drop table if exists actor;

drop table if exists actor_dvd;

drop table if exists author;

drop table if exists author_book;

drop table if exists book;

drop table if exists dvd;

drop table if exists reader;

