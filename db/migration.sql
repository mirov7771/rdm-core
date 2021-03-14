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
    role    varchar(50)
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