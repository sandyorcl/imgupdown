--Login

--TBL login
create table imglogin
(
password varchar(50),
password_hint_id int,
password_hint_password varchar(50),
first_name varchar(50),
last_name varchar(50),
gender varchar(50),
mobile varchar(50),
email_id varchar(50),
address1 varchar(250),
address2 varchar(250),
address3 varchar(250),
pincode varchar(10),
state varchar(100),
country varchar(100),
password_changed_on datetime,
wrong_login_attempt int,
role int,
group int,
is_active varchar(50),
last_accessed datetime,
created_by varchar(50),
created_on datetime
);

--For casesenstive
alter table imglogin alter column [password] varchar(50) collate SQL_Latin1_General_CP1_CS_AS

--TBL login_audit
create table login_audit
(
login varchar(50),
old_password varchar(50),
last_modified_password date,
role int
);


create table role_master
(
role int,
role_name varchar(50)
);


create table FileUploadDownload
(
filename varchar(250),
filesize varchar(20),
filepath varchar(500),
filetype varchar(10),
uploadstatus varchar(253),
uploadedby varchar(50),
uploadedon datetime
);
