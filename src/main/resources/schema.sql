drop table if exists student cascade;
drop table if exists meeting cascade;
drop table if exists presence cascade;
drop table if exists meeting_to_presence cascade;
drop table if exists attendance cascade;
drop table if exists classes cascade;
drop table if exists grades cascade;

create table if not exists student
(
    id       bigint primary key generated by default as identity,
    name     varchar(255),
    skype    varchar(255),
    telegram varchar(255),
    github   varchar(255),
    botscore integer,
    isActive varchar(255)
);


-- create table if not exists meeting(
--     id bigint primary key  generated by default as identity,
--     date DATE,
--     mark bigint
-- );
--
-- create table if not exists presence(
--     id bigint primary key generated by default as identity,
--     student bigint references student(id),
--     date DATE,
--     presence varchar(255)
-- );
-- create table meeting_to_presence(
--     meeting_id bigint references meeting(id),
--     presence_id bigint references presence(id)
-- )
-- Таблица студентов
-- CREATE TABLE students (
--                           student_id SERIAL PRIMARY KEY, -- Уникальный идентификатор студента
--                           first_name VARCHAR(50) NOT NULL,
--                           last_name VARCHAR(50) NOT NULL,
--     -- ... (другие атрибуты, например, дата рождения, группа и т.д.)
-- );

-- Таблица занятий
CREATE TABLE classes
(
    class_id   bigint PRIMARY KEY,
    class_name VARCHAR(100) NOT NULL,
    class_date date not null
    -- ... (другие атрибуты, например, преподаватель, аудитория и т.д.)
);

-- Таблица посещаемости
CREATE TABLE attendance
(
    id         bigint primary key generated by default as identity,
    student_id bigint references student (id),       -- Связь со студентом
    class_id   bigint references classes (class_id), -- Связь с занятием
    is_present boolean not null
);

-- Таблица оценок
CREATE TABLE grades
(
    grade_id   SERIAL PRIMARY KEY,
    student_id INTEGER REFERENCES student (id),       -- Связь со студентом
    class_id   INTEGER REFERENCES classes (class_id), -- Связь с занятием
    grade      INTEGER                                -- Например, для оценок от 0.0 до 10.0
);
