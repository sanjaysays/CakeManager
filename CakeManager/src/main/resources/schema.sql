create table T_CAKES
(
   id identity	not null,
   cake_name varchar(255) not null, 
   cake_description varchar(255) not null,
   cake_price numeric not null
);


create table T_USERS
(
   id identity	not null,
   providerUserId varchar(100) not null, 
   email varchar(100) not null,
   enabled varchar(100) not null,
   displayName varchar(100) not null,
   createdDate Date not null,
   modifiedDate Date not null,
   password varchar(100) not null,
   provider varchar(100) not null,
   roleId int not null
);

