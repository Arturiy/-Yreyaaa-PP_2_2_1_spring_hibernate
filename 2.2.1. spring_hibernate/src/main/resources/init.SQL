CREATE TABLE CARS
(
    ID     int primary key auto_increment,
    SERIES int          not null,
    MODEL  varchar(255) not null
)
CREATE table USERS
(
    ID        int primary key auto_increment,
    NAME      varchar(255) not null,
    LAST_NAME varchar(255) not null,
    EMAIL     varchar(255) not null,
    CAR_ID    int,
    foreign key (CAR_ID) references CARS (ID)
);

