create database QLKHOAHOC;
use QLKHOAHOC;
# drop database QLKHOAHOC;
create table StudentGrade
(
    EnrollmentID bigint primary key auto_increment,
    CourseID     bigint not null,
    StudentID    bigint not null,
    Gradle       float  not null
);
create table Department
(
    DepartmentID  bigint primary key auto_increment,
    `Name`        varchar(50) not null,
    Budget        double      not null,
    StartDate     date        not null,
    Administrator varchar(50) not null
);
create table Course
(
    CourseID     bigint primary key auto_increment,
    Title        varchar(50) not null,
    Credits      double      not null,
    DepartmentID bigint
);
create table OnlineCourse
(
    CourseID bigint primary key,
    URL      varchar(255) not null
);
create table OnsiteCourse
(
    CourseID bigint primary key auto_increment,
    Location varchar(500),
    Days     int  not null,
    Time     date not null
);
create table CourseInstructor
(
    CourseID bigint not null,
    PersonID bigint not null,
    primary key (CourseID, PersonID)
);
create table Person
(
    PersonID       bigint primary key auto_increment,
    Lastname       varchar(100) not null,
    Firstname      varchar(100) not null,
    HireDate       date          null,
    EnrollmentDate date          null
);
create table OfficeAssignment
(
    InstructorID bigint primary key,
    Location     varchar(500) not null,
    TimesStamp   TIMESTAMP    not null
);
alter table `OnsiteCourse`
    add constraint fk_1 foreign key (CourseID) references `Course` (CourseID);
alter table `OnsiteCourse`
    add constraint fk_2 foreign key (CourseID) references `Course` (CourseID);
alter table `Course`
    add constraint fk_3 foreign key (DepartmentID) references `Department` (DepartmentID);
alter table `CourseInstructor`
    add constraint fk_4 foreign key (CourseID) references `Course` (CourseID);
alter table `CourseInstructor`
    add constraint fk_5 foreign key (PersonID) references `Person` (PersonID);
alter table `StudentGrade`
    add constraint fk_6 foreign key (CourseID) references `Course` (CourseID);
alter table `StudentGrade`
    add constraint fk_7 foreign key (StudentID) references `Person` (PersonID);
alter table `OfficeAssignment`
    add constraint fk_8 foreign key (InstructorID) references `Person` (PersonID);

-- ############################### insert statement ############################### --

insert into Person
values (null, 'Thanh', 'Bui Manh', '2022-10-10', '2022-10-10'),
       (null, 'Dai', 'Nguyen Huu', '2022-10-12', '2022-01-01'),
       (null, 'Thi', 'Vo Thien', '2012-10-08', '2002-05-03'),
       (null, 'Nghi', 'Pham Hong Phuong', '2023-01-02', '2022-12-12'),
       (null, 'Thinh', 'Chau Phu', '2022-10-11', '2002-09-08');

insert into Department
values (null, 'Phòng chống ma túy', 100000, '2023-10-10', 'ADMIN'),
       (null, 'Phòng chống mấy đứa cầm Vayne đi top', 100000, '2023-10-10', 'USER');

insert into Course
values (null, 'Dạy làm giàu phần 1', 100, 1),
       (null, 'Dạy làm giàu phần 2', 120, 2),
       (null, 'Bí kíp tán gái quyển 1', 12000, 2),
       (null, 'Bí kíp tán gái quyển 2', 18000, 2),
       (null, 'Tại sao con cá biết bơi ?', 10, 1),
       (null, 'Cách đu idol thành công', 20, 1),
       (null, 'Cách trờ để sở hữu tánh nóng như kem', 5, 1);

insert into OfficeAssignment
values (1, 'Tân Xuân, Hóc Môn, Sài Gòn', '2023-10-10 21:22:01'),
       (2, 'Niu dót, Ờ me ri cà', '2023-12-09 12:18:03');

insert into OnlineCourse
values (3,'https://bikiptangai/p1'),
       (4,'https://bikiptangai/p2');

insert into OnsiteCourse
values (1,'Trần Duy Hưng, Hà Nội',30,'2023-02-03'),
       (2,'Ngã tư sinh tử, CSGO',23,'2023-03-04');

insert into StudentGrade
values (null,3,1,10),
       (null,4,2,9);

-- ##################################### end ##################################### --

-- TIMESTAMP - format YYYY-MM-DD HH:MI:SS
-- DATE - format YYYY-MM-DD