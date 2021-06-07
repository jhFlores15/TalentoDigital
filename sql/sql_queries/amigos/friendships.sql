
-- 1)
select users.first_name, users.last_name, user2.first_name as friend_first_name, user2.last_name as friend_last_name from users
left join friendships as f on f.user_id = users.id
left join users as user2 on user2.id = f.friend_id
where users.first_name = "Kermit";

-- 2)
select users.first_name, users.last_name, count(f.friend_id) as total_friends from users
left join friendships as f on f.user_id = users.id
left join users as user2 on user2.id = f.friend_id
group by users.id
order by total_friends desc;

-- 3)
select users.first_name, users.last_name, count(f.friend_id) as total_friends from users
left join friendships as f on f.user_id = users.id
left join users as user2 on user2.id = f.friend_id
group by users.id
order by total_friends desc
limit 1;

-- 4)
insert into users (first_name, last_name, created_at) values ("matías", "yañez", now());
insert into users (first_name, last_name, created_at) values ("magdalena", "pizarro", now());
insert into users (first_name, last_name, created_at) values ("pablo", "pizarro", now());
insert into friendships (user_id, friend_id, created_at) values (2, 6, now());
insert into friendships (user_id, friend_id, created_at) values (4, 7, now());
insert into friendships (user_id, friend_id, created_at) values (5, 8, now());

-- 5)
select users.first_name, users.last_name, user2.first_name as friend_first_name, user2.last_name as friend_last_name from users
left join friendships as f on f.user_id = users.id
left join users as user2 on user2.id = f.friend_id
where users.first_name = "Eli"
order by user2.first_name desc;

-- 6)
delete from friendships where id = 5;

-- 7)
select users.first_name, users.last_name, user2.first_name as friend_first_name, user2.last_name as friend_last_name from users
left join friendships as f on f.user_id = users.id
left join users as user2 on user2.id = f.friend_id
where user2.first_name is not null;
