# RIVER-VOYAGE-MANAGEMENT-SYSTEM
River Voyage Management System

● Problem Statement:
❖ The aim of the project is to design a Voyage Management System for the
Ganga Vilas Project of river cruises on the Ganga River.
❖ User as well as Admin side are designed using MySQL, JDBC and Java
Swing Library (for GUI).
❖ User functionalities include Login, Signup, add personal details, view
voyage, package and cruise options and book a voyage.
❖ Admin functionalities include viewpassenger database, addvoyages, view
voyage, package and cruise options.

● Software Tools
❖ Frontend: Java Swing
❖ Backend: MySQL

● Technologies Used
❖ MySQL: MySQL is a widely used relational database management
system (RDBMS). MySQL provided the backend for our Voyage
management system in which multiple related tables were created forming
a relational database.
❖ JDBC: Java Database Connectivity (JDBC) is an application programming
interface (API) for the Java programming language. JDBC was used.
Used to connect and execute queries with the database in MySQL.
❖ Java Swing: Swing is a Java Foundation Classes [JFC] library and an

extension of the Abstract Window Toolkit [AWT]. Used for the GUI.

● ER Diagram

● Normalized Tables
❖ Passenger

Attribute Data type Constraint
id int Primary key
Name varchar(30) Not null
address varchar(100) Not null
phone_no varchar(11) Unique
email varchar(50) Unique
Gender varchar(20) Not null
DOB date Not null

cruise_name varchar(100) -
package_name varchar(100) -
total_person int -
total_price int -

❖ Cruises

Attribute Data type Constraint
cruise_id int Primary key
cruise_name varchar(40) -
capacity int -

1NF Normalization:

● Cruises table must contain a column to specify the ports that every cruise
halts at.
● Due to the presence of multiple ports in a cruise’s path, the ports column
will be a multi-valued attribute.
● Thus, by 1NF:
If a relation contains a composite or multi-valued attribute, it violates the
first normal form, or the relation is in first normal form if it does not contain
any composite or multi-valued attribute.
● So, to convert it to 1NF, we create a separate table for Ports as follows.

❖Ports

Attribute Data type Constraint
Cruise_id int Foreign key
port_id int Primary key
place_name varchar(50) -
stop_number int -
stop_type varchar(50) -

❖ Voyage
Attribute Data type Constraint
cruise_id int Foreign key
Voyage_id int Primary key

start_date date -
end_date date -
status varchar(30) -

❖ Account

Attribute Data type Constraint
Acc_no int Primary key
name varchar(50) -
password varchar(50) Not Null
Security varchar(50) -
answer varchar(50) -

❖ Admin

Attribute Data type Constraint

username varchar(30) Primary key
password varchar(10) Not null

❖ Packages

Attribute Data type Constraint
cruise_id int Foreign key
package_name varchar(30) Primary key
cost int -

2NF and 3NF Normalization
● 2NF requires that each non-key attribute be dependent on the primary
key. This means that each column should be directly related to the
primary key, and not to other columns.
● 3NF builds on 2NF by requiring that all non-key attributes are
independent of each other. This means that each column should be
directly related to the primary key, and not to any other columns in the
same table.
● Our database tables satisfy both of the above conditions thus, they are
already in 2NF and 3NF.
