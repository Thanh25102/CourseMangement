create database QLKHOAHOC;
use QLKHOAHOC;
select * from OnlineCourse as p inner join course as c on p.courseId = c.courseId  where credits = 18;
# drop database QLKHOAHOC;
create table StudentGrade
(
    EnrollmentID bigint primary key auto_increment,
    CourseID     bigint not null,
    StudentID    bigint not null,
    Grade        float  not null
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
    CourseID bigint primary key,
    Location varchar(500),
    Days     int    not null,
    Time     bigint not null
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
    HireDate       date         null,
    EnrollmentDate date         null
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
values (null, 'Ph??ng ch???ng ma t??y', 100000, '2023-10-10', 'ADMIN'),
       (null, 'Ph??ng ch???ng m???y ?????a c???m Vayne ??i top', 100000, '2023-10-10', 'USER');

insert into Course
values (null, 'D???y l??m gi??u ph???n 1', 100, 1),
       (null, 'D???y l??m gi??u ph???n 2', 120, 2),
       (null, 'B?? k??p t??n g??i quy???n 1', 12000, 2),
       (null, 'B?? k??p t??n g??i quy???n 2', 18000, 2),
       (null, 'T???i sao con c?? bi???t b??i ?', 10, 1),
       (null, 'C??ch ??u idol th??nh c??ng', 20, 1),
       (null, 'C??ch tr??? ????? s??? h???u t??nh n??ng nh?? kem', 5, 1);

insert into CourseInstructor
values (1, 2),
       (2, 3),
       (3, 4);

insert into OfficeAssignment
values (1, 'T??n Xu??n, H??c M??n, S??i G??n', '2023-10-10 21:22:01'),
       (2, 'Niu d??t, ??? me ri c??', '2023-12-09 12:18:03');

insert into OnlineCourse
values (3, 'https://bikiptangai/p1'),
       (4, 'https://bikiptangai/p2');

insert into OnsiteCourse
values (1, 'Tr???n Duy H??ng, H?? N???i', 30, 10.2),
       (2, 'Ng?? t?? sinh t???, CSGO', 23, 30.8);

insert into StudentGrade
values (null, 3, 1, 10),
       (null, 4, 2, 9);

-- ##################################### end ##################################### --

-- TIMESTAMP - format YYYY-MM-DD HH:MI:SS
-- DATE - format YYYY-MM-DD