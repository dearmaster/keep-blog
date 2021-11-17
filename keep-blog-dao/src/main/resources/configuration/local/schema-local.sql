-- there is foreign keys so need drop by sequence
drop table if exists t_category_article_map;
drop table if exists t_article;
drop table if exists t_category;
drop table if exists t_user;

create table t_user (
    id uuid default random_uuid() primary key,
    username varchar(30) unique not null
);

create table t_article (
    id uuid default random_uuid() primary key,
    subject varchar(200) not null,
    content varchar(1000) not null,
    unique key (subject, content)
);

create table t_category (
    id uuid default random_uuid() primary key,
    user_id uuid,
    category varchar(30) not null,
    unique key (user_id, category)
);

create table t_category_article_map (
    id uuid default random_uuid() primary key,
    category_id uuid,
    article_id uuid,
    foreign key (category_id) references t_category (id),
    foreign key (article_id) references t_article (id)
);

--alter table t_category_article_map add foreign key (category_id) references t_category (id);