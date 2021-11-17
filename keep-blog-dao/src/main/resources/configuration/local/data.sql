delete from t_category_article_map;
delete from t_article;
delete from t_category;
delete from t_user;


insert into t_user (username) values ('lily');
insert into t_user (username) values ('jay');

insert into t_category (user_id, category)  select id, '随笔' from t_user where username = 'lily';
insert into t_category (user_id, category)  select id, 'SpringBoot' from t_user where username = 'lily';
insert into t_category (user_id, category)  select id, 'Vue' from t_user where username = 'lily';
insert into t_category (user_id, category)  select id, 'Shell' from t_user where username = 'lily';
insert into t_category (user_id, category)  select id, '随笔' from t_user where username = 'jay';
insert into t_category (user_id, category)  select id, 'Java' from t_user where username = 'jay';

insert into t_article (subject, content)  values ('My First Blog', 'Hi, This is my first blog! Please start me if you have interest to my articles');
insert into t_article (subject, content)  values ('My First Blog', 'Hi, This is the first blog from Jay! ');

insert into t_category_article_map (category_id, article_id)  select c.id, a.id from t_category c, t_article a, t_user u where c.user_id = u.id and u.username = 'jay' and c.category = '随笔' and a.content like '%Jay%';
insert into t_category_article_map (category_id, article_id)  select c.id, a.id from t_category c, t_article a, t_user u where c.user_id = u.id and u.username = 'lily' and c.category = '随笔' and a.content not like '%Jay%';