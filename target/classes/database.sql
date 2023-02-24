create database QLKHOAHOC;
use QLKHOAHOC;
# drop database QLKHOAHOC;
create table StudentGrade
(
    EnrollmentI bigint primary key auto_increment,
    CourseID    bigint not null,
    StudentID   bigint not null,
    Gradle      float  not null
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
    PersonID  bigint primary key auto_increment,
    Lastname  varchar(100) not null,
    Firstname varchar(100) not null

);
create table OfficeAssignment
(
    InstructorID bigint primary key auto_increment,
    Location     varchar(500) not null,
    TimesStamp   TIMESTAMP    not null
);
alter table `onlinecourse`
    add constraint fk_1 foreign key (CourseID) references `Course` (CourseID);
alter table `onsitecourse`
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