create table user_session
(
    id 			bigint GENERATED ALWAYS AS identity,
    sessionId 	varchar(50),
    phone 		varchar(20) null,
    code 		varchar(50) null,
    accesstoken varchar(255) null,
    userid 		bigint,
    expiry 		timestamp
);

create index x1_user_session on user_session(sessionid, phone, expiry);
create index x2_user_session on user_session(sessionid, code, expiry);
create index x3_user_session on user_session(accesstoken);
create index x4_user_session on user_session(sessionid, expiry);

create table user_profile
(
    userid 	bigint GENERATED ALWAYS AS identity primary key,
    phone 	varchar(20),
    fio 	varchar(150) null,
    email 	varchar(50) null,
    indate 	timestamp,
    role    varchar(50),
    asked   boolean default false,
    location varchar(255) null
);

create index x1_user_profile on user_profile(phone);

create table otp_code
(
    code 	varchar(20),
    phone 	varchar(20),
    type 	varchar(50),
    expiry 	timestamp
);

create index x1_otp_code on otp_code(code, phone, type, expiry);

create table category(
    categoryid   bigint not null generated always as identity primary key,
    parentid     bigint,
    categoryname varchar(250),
    logofile     varchar(150) null,
    description  text null,
    type         smallint,
    priority     smallint
);

create index x1_category on category(parentid, type);

create table region(
    regionid   bigint not null generated always as identity primary key,
    regionname varchar(200) null
);

create unique index x1_region on region(regionname);

create table region_link(
    linkid   bigint not null generated always as identity primary key,
    regionid bigint,
    childid  bigint
);

create index x1_region_link on region_link(childid);
create index x2_region_link on region_link(regionid);