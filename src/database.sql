-- Table: Guests
CREATE TABLE Guests (
    Gid int  NOT NULL AUTO_INCREMENT,
    first_name varchar(40)  NOT NULL,
    last_name varchar(40)  NOT NULL,
    member_since date  NOT NULL,
    TotalSpent int  NOT NULL,
    MembershipLevel int  NOT NULL,
    CONSTRAINT Guests_pk PRIMARY KEY (Gid)
);

-- Table: bookings
CREATE TABLE bookings (
    Bid int  NOT NULL AUTO_INCREMENT,
    date_in date  NOT NULL,
    date_out date  NOT NULL,
    Gid int  NOT NULL,
    Rid int  NOT NULL,
    CONSTRAINT bookings_pk PRIMARY KEY (Bid)
);

-- Table: hotels
CREATE TABLE hotels (
    Hid int  NOT NULL AUTO_INCREMENT,
    Name varchar(40)  NOT NULL,
    Country varchar(40)  NOT NULL,
    City varchar(40)  NOT NULL,
    Rooms int  NOT NULL,
    CONSTRAINT hotels_pk PRIMARY KEY (Hid)
);

-- Table: payments
CREATE TABLE payments (
    Pid int  NOT NULL AUTO_INCREMENT,
    IsPaid boolean  NOT NULL,
    TotalPrice int  NOT NULL,
    Bid int  NOT NULL,
    CONSTRAINT payments_pk PRIMARY KEY (Pid)
);

-- Table: rooms
CREATE TABLE rooms (
    Rid int  NOT NULL AUTO_INCREMENT,
    Rnumber int  NOT NULL,
    Type varchar(40)  NOT NULL,
    Status varchar(10)  NOT NULL,
    Price int  NOT NULL,
    Hid int  NOT NULL,
    CONSTRAINT rooms_pk PRIMARY KEY (Rid)
);

-- Table: users
CREATE TABLE users (
    Uid int  NOT NULL AUTO_INCREMENT,
    FirstName varchar(40)  NOT NULL,
    LastName varchar(40)  NOT NULL,
    IsManager boolean  NOT NULL,
    Password varchar(40)  NOT NULL,
    Hid int  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (Uid)
);

-- foreign keys
-- Reference: bookings_Guests (table: bookings)
ALTER TABLE bookings ADD CONSTRAINT bookings_Guests
    FOREIGN KEY (Gid)
    REFERENCES Guests (Gid)  
;

-- Reference: bookings_rooms (table: bookings)
ALTER TABLE bookings ADD CONSTRAINT bookings_rooms
    FOREIGN KEY (Rid)
    REFERENCES rooms (Rid)  
;

-- Reference: payments_bookings (table: payments)
ALTER TABLE payments ADD CONSTRAINT payments_bookings
    FOREIGN KEY (Bid)
    REFERENCES bookings (Bid)  
;

-- Reference: rooms_hotels (table: rooms)
ALTER TABLE rooms ADD CONSTRAINT rooms_hotels
    FOREIGN KEY (Hid)
    REFERENCES hotels (Hid)  
;

-- Reference: users_hotels (table: users)
ALTER TABLE users ADD CONSTRAINT users_hotels
    FOREIGN KEY (Hid)
    REFERENCES hotels (Hid)  
;

INSERT INTO table CUSTOMERS ('Vera','Irwin','29/10/2018');
INSERT INTO table CUSTOMERS ('Erica','Valenzuela','30/10/2018');
INSERT INTO table CUSTOMERS ('Oscar','Valencia','31/10/2018');
INSERT INTO table CUSTOMERS ('Quin','Barrera','28/10/2018');
INSERT INTO table CUSTOMERS ('Len','Moss','26/10/2018');
INSERT INTO table CUSTOMERS ('Ina','Deleon','31/10/2018');
INSERT INTO table CUSTOMERS ('Fredericka','Olsen','27/10/2018');
INSERT INTO table CUSTOMERS ('Upton','Graves','27/10/2018');
INSERT INTO table CUSTOMERS ('Hyatt','Petersen','27/10/2018');
INSERT INTO table CUSTOMERS ('Charissa','Dale','26/10/2018');
INSERT INTO table CUSTOMERS ('Elvis','Farrell','26/10/2018');
INSERT INTO table CUSTOMERS ('Hiram','Edwards','29/10/2018');
INSERT INTO table CUSTOMERS ('Miriam','Short','29/10/2018');
INSERT INTO table CUSTOMERS ('Harding','Sosa','28/10/2018');
INSERT INTO table CUSTOMERS ('Illiana','Cross','30/10/2018');
INSERT INTO table CUSTOMERS ('Hasad','Carey','26/10/2018');
INSERT INTO table CUSTOMERS ('Victor','Santos','01/11/2018');
INSERT INTO table CUSTOMERS ('Magee','Tanner','28/10/2018');
INSERT INTO table CUSTOMERS ('Ali','Vazquez','28/10/2018');
INSERT INTO table CUSTOMERS ('Rahim','Kelley','29/10/2018');
INSERT INTO table CUSTOMERS ('Latifah','Estrada','30/10/2018');
INSERT INTO table CUSTOMERS ('Prescott','Fields','31/10/2018');
INSERT INTO table CUSTOMERS ('Duncan','Finch','31/10/2018');
INSERT INTO table CUSTOMERS ('Brandon','Wilkins','30/10/2018');
INSERT INTO table CUSTOMERS ('Melyssa','Hull','30/10/2018');
INSERT INTO table CUSTOMERS ('Knox','Hester','31/10/2018');
INSERT INTO table CUSTOMERS ('Otto','Meadows','28/10/2018');
INSERT INTO table CUSTOMERS ('Nina','Dickerson','01/11/2018');
INSERT INTO table CUSTOMERS ('Tiger','Clarke','26/10/2018');
INSERT INTO table CUSTOMERS ('Ginger','Michael','28/10/2018');
INSERT INTO table CUSTOMERS ('Finn','Prince','30/10/2018');
INSERT INTO table CUSTOMERS ('Owen','Rios','27/10/2018');
INSERT INTO table CUSTOMERS ('Hyacinth','Hudson','28/10/2018');
INSERT INTO table CUSTOMERS ('Justina','Petersen','01/11/2018');
INSERT INTO table CUSTOMERS ('Brianna','Mcconnell','27/10/2018');
INSERT INTO table CUSTOMERS ('Shana','Garrison','29/10/2018');
INSERT INTO table CUSTOMERS ('Odessa','Allison','01/11/2018');
INSERT INTO table CUSTOMERS ('Rana','Whitley','26/10/2018');
INSERT INTO table CUSTOMERS ('Zeph','Faulkner','30/10/2018');
INSERT INTO table CUSTOMERS ('Hedy','Sloan','27/10/2018');
INSERT INTO table CUSTOMERS ('Ocean','Allen','26/10/2018');
INSERT INTO table CUSTOMERS ('Jonah','Conway','29/10/2018');
INSERT INTO table CUSTOMERS ('Jaime','Cobb','30/10/2018');
INSERT INTO table CUSTOMERS ('Dante','Landry','01/11/2018');
INSERT INTO table CUSTOMERS ('Grady','Lynch','01/11/2018');
INSERT INTO table CUSTOMERS ('Christian','Wiggins','28/10/2018');
INSERT INTO table CUSTOMERS ('Oscar','Green','01/11/2018');
INSERT INTO table CUSTOMERS ('Cedric','Chavez','29/10/2018');
INSERT INTO table CUSTOMERS ('Amity','Jensen','29/10/2018');
INSERT INTO table CUSTOMERS ('Lavinia','Hale','28/10/2018');
INSERT INTO table CUSTOMERS ('Kevin','Mcintosh','31/10/2018');
INSERT INTO table CUSTOMERS ('Caesar','Buck','29/10/2018');
INSERT INTO table CUSTOMERS ('Megan','Boyer','31/10/2018');
INSERT INTO table CUSTOMERS ('Imelda','Forbes','30/10/2018');
INSERT INTO table CUSTOMERS ('Anastasia','Goodman','29/10/2018');
INSERT INTO table CUSTOMERS ('Demetria','Giles','27/10/2018');
INSERT INTO table CUSTOMERS ('Alika','Dorsey','01/11/2018');
INSERT INTO table CUSTOMERS ('Marvin','Rojas','26/10/2018');
INSERT INTO table CUSTOMERS ('Quinlan','Parker','31/10/2018');
INSERT INTO table CUSTOMERS ('Tashya','Marks','27/10/2018');
INSERT INTO table CUSTOMERS ('Inez','Leblanc','01/11/2018');
INSERT INTO table CUSTOMERS ('Veda','Oneal','01/11/2018');
INSERT INTO table CUSTOMERS ('Mason','Nelson','31/10/2018');
INSERT INTO table CUSTOMERS ('Keegan','Brock','01/11/2018');
INSERT INTO table CUSTOMERS ('Beau','Adkins','28/10/2018');
INSERT INTO table CUSTOMERS ('Kamal','Hodges','26/10/2018');
INSERT INTO table CUSTOMERS ('Britanni','Hall','29/10/2018');
INSERT INTO table CUSTOMERS ('Hedy','Page','31/10/2018');
INSERT INTO table CUSTOMERS ('Omar','Pace','01/11/2018');
INSERT INTO table CUSTOMERS ('Mufutau','Blair','27/10/2018');
INSERT INTO table CUSTOMERS ('Neil','Pierce','30/10/2018');
INSERT INTO table CUSTOMERS ('Mary','Williams','01/11/2018');
INSERT INTO table CUSTOMERS ('Sylvia','Klein','27/10/2018');
INSERT INTO table CUSTOMERS ('August','Fry','01/11/2018');
INSERT INTO table CUSTOMERS ('Jackson','Kidd','28/10/2018');
INSERT INTO table CUSTOMERS ('Keely','Chen','30/10/2018');
INSERT INTO table CUSTOMERS ('Dai','Thornton','26/10/2018');
INSERT INTO table CUSTOMERS ('Carl','Burt','30/10/2018');
INSERT INTO table CUSTOMERS ('Hollee','Day','27/10/2018');
INSERT INTO table CUSTOMERS ('Alexander','Bishop','28/10/2018');
INSERT INTO table CUSTOMERS ('Hyatt','Goodwin','31/10/2018');
INSERT INTO table CUSTOMERS ('Kennedy','French','27/10/2018');
INSERT INTO table CUSTOMERS ('Nathaniel','Wells','26/10/2018');
INSERT INTO table CUSTOMERS ('Travis','Barnes','30/10/2018');
INSERT INTO table CUSTOMERS ('Wesley','Hickman','26/10/2018');
INSERT INTO table CUSTOMERS ('Risa','Hutchinson','27/10/2018');
INSERT INTO table CUSTOMERS ('Alden','Barrett','30/10/2018');
INSERT INTO table CUSTOMERS ('Declan','Gallagher','29/10/2018');
INSERT INTO table CUSTOMERS ('Megan','Kent','27/10/2018');
INSERT INTO table CUSTOMERS ('Venus','Anderson','01/11/2018');
INSERT INTO table CUSTOMERS ('Marsden','Puckett','26/10/2018');
INSERT INTO table CUSTOMERS ('Rajah','Cruz','27/10/2018');
INSERT INTO table CUSTOMERS ('Zane','Rodgers','30/10/2018');
INSERT INTO table CUSTOMERS ('Joseph','Long','28/10/2018');
INSERT INTO table CUSTOMERS ('Whilemina','Burnett','30/10/2018');
INSERT INTO table CUSTOMERS ('Jael','Cantrell','30/10/2018');
INSERT INTO table CUSTOMERS ('Gary','Weiss','31/10/2018');
INSERT INTO table CUSTOMERS ('Buffy','Reid','31/10/2018');
INSERT INTO table CUSTOMERS ('Hoyt','Acevedo','31/10/2018');
INSERT INTO table CUSTOMERS ('Felix','Thomas','01/11/2018');
INSERT INTO table CUSTOMERS ('Aristotle','Emerson','28/10/2018');
INSERT INTO table CUSTOMERS ('Fredericka','Mcmahon','29/10/2018');
INSERT INTO table CUSTOMERS ('Barry','Garza','27/10/2018');
INSERT INTO table CUSTOMERS ('Virginia','Mullen','28/10/2018');
INSERT INTO table CUSTOMERS ('William','Bean','28/10/2018');
INSERT INTO table CUSTOMERS ('Shana','Fox','30/10/2018');
INSERT INTO table CUSTOMERS ('Cleo','Elliott','28/10/2018');
INSERT INTO table CUSTOMERS ('Mannix','Stanley','31/10/2018');
INSERT INTO table CUSTOMERS ('Wesley','Heath','26/10/2018');
INSERT INTO table CUSTOMERS ('Malcolm','Daugherty','30/10/2018');
INSERT INTO table CUSTOMERS ('Yardley','Clemons','28/10/2018');
INSERT INTO table CUSTOMERS ('Nora','Gallagher','01/11/2018');
INSERT INTO table CUSTOMERS ('Justin','Mccarty','31/10/2018');
INSERT INTO table CUSTOMERS ('Kai','George','27/10/2018');
INSERT INTO table CUSTOMERS ('Daniel','Buck','31/10/2018');
INSERT INTO table CUSTOMERS ('Mira','Cain','30/10/2018');
INSERT INTO table CUSTOMERS ('Robert','Fuller','31/10/2018');
INSERT INTO table CUSTOMERS ('Abraham','Keith','27/10/2018');
INSERT INTO table CUSTOMERS ('Ezekiel','Bailey','30/10/2018');
INSERT INTO table CUSTOMERS ('Florence','Baldwin','27/10/2018');
INSERT INTO table CUSTOMERS ('Hammett','Marquez','28/10/2018');
INSERT INTO table CUSTOMERS ('Kareem','Reed','26/10/2018');
INSERT INTO table CUSTOMERS ('Martina','Mercer','01/11/2018');
INSERT INTO table CUSTOMERS ('Camille','Cleveland','01/11/2018');
INSERT INTO table CUSTOMERS ('Flavia','Williamson','28/10/2018');
INSERT INTO table CUSTOMERS ('Jolie','Cook','26/10/2018');
INSERT INTO table CUSTOMERS ('Bertha','Parsons','30/10/2018');
INSERT INTO table CUSTOMERS ('Raphael','Holcomb','30/10/2018');
INSERT INTO table CUSTOMERS ('Nero','Salazar','31/10/2018');
INSERT INTO table CUSTOMERS ('Darrel','Ballard','30/10/2018');
INSERT INTO table CUSTOMERS ('Xenos','Berger','01/11/2018');
INSERT INTO table CUSTOMERS ('Keefe','Buck','28/10/2018');
INSERT INTO table CUSTOMERS ('Cally','Brady','28/10/2018');
INSERT INTO table CUSTOMERS ('Brooke','Burris','30/10/2018');
INSERT INTO table CUSTOMERS ('Clio','Boyer','31/10/2018');
INSERT INTO table CUSTOMERS ('Christen','Greene','27/10/2018');
INSERT INTO table CUSTOMERS ('Owen','Massey','30/10/2018');
INSERT INTO table CUSTOMERS ('Wang','Leon','31/10/2018');
INSERT INTO table CUSTOMERS ('Marsden','Evans','28/10/2018');
INSERT INTO table CUSTOMERS ('Joel','Ray','31/10/2018');
INSERT INTO table CUSTOMERS ('Oren','Alford','01/11/2018');
INSERT INTO table CUSTOMERS ('Bree','Gentry','27/10/2018');
INSERT INTO table CUSTOMERS ('Cynthia','Martin','29/10/2018');
INSERT INTO table CUSTOMERS ('Aristotle','Price','31/10/2018');
INSERT INTO table CUSTOMERS ('Jackson','Stephens','01/11/2018');
INSERT INTO table CUSTOMERS ('Ori','Wynn','01/11/2018');
INSERT INTO table CUSTOMERS ('Eagan','Guerrero','27/10/2018');
INSERT INTO table CUSTOMERS ('Gillian','Holland','26/10/2018');
INSERT INTO table CUSTOMERS ('Emerson','Vazquez','01/11/2018');
INSERT INTO table CUSTOMERS ('Fredericka','Velez','27/10/2018');
INSERT INTO table CUSTOMERS ('Lewis','Wright','28/10/2018');
INSERT INTO table CUSTOMERS ('Wing','Fields','31/10/2018');
INSERT INTO table CUSTOMERS ('Hanna','Beach','31/10/2018');
INSERT INTO table CUSTOMERS ('Myles','Gordon','27/10/2018');
INSERT INTO table CUSTOMERS ('Irma','Lee','29/10/2018');
INSERT INTO table CUSTOMERS ('Abdul','Rogers','29/10/2018');
INSERT INTO table CUSTOMERS ('Kyle','Holden','26/10/2018');
INSERT INTO table CUSTOMERS ('Selma','Peters','26/10/2018');
INSERT INTO table CUSTOMERS ('Dominic','Golden','29/10/2018');
INSERT INTO table CUSTOMERS ('Neville','Hill','28/10/2018');
INSERT INTO table CUSTOMERS ('Barbara','Sparks','01/11/2018');
INSERT INTO table CUSTOMERS ('Rebekah','Hanson','27/10/2018');
INSERT INTO table CUSTOMERS ('Anjolie','Rush','28/10/2018');
INSERT INTO table CUSTOMERS ('Curran','Haynes','27/10/2018');
INSERT INTO table CUSTOMERS ('Emi','Lamb','29/10/2018');
INSERT INTO table CUSTOMERS ('Judith','Oneil','26/10/2018');
INSERT INTO table CUSTOMERS ('Kiara','Maldonado','28/10/2018');
INSERT INTO table CUSTOMERS ('Phoebe','Sloan','29/10/2018');
INSERT INTO table CUSTOMERS ('Ruby','Collier','28/10/2018');
INSERT INTO table CUSTOMERS ('Camille','Hanson','28/10/2018');
INSERT INTO table CUSTOMERS ('Otto','Campbell','26/10/2018');
INSERT INTO table CUSTOMERS ('William','Byrd','26/10/2018');
INSERT INTO table CUSTOMERS ('Mechelle','Todd','28/10/2018');
INSERT INTO table CUSTOMERS ('Emery','Reyes','28/10/2018');
INSERT INTO table CUSTOMERS ('Amity','Conway','28/10/2018');
INSERT INTO table CUSTOMERS ('Xanthus','Gilmore','26/10/2018');
INSERT INTO table CUSTOMERS ('Harriet','Craft','31/10/2018');
INSERT INTO table CUSTOMERS ('Angela','Sherman','29/10/2018');
INSERT INTO table CUSTOMERS ('Jaime','Murray','27/10/2018');
INSERT INTO table CUSTOMERS ('Urielle','Frazier','01/11/2018');
INSERT INTO table CUSTOMERS ('Francesca','Reynolds','26/10/2018');
INSERT INTO table CUSTOMERS ('Murphy','Conner','27/10/2018');
INSERT INTO table CUSTOMERS ('Chanda','Shepard','01/11/2018');
INSERT INTO table CUSTOMERS ('Wylie','Knapp','28/10/2018');
INSERT INTO table CUSTOMERS ('Josephine','Buckley','30/10/2018');
INSERT INTO table CUSTOMERS ('Mollie','Shepard','31/10/2018');
INSERT INTO table CUSTOMERS ('Astra','Olson','30/10/2018');
INSERT INTO table CUSTOMERS ('Asher','Albert','29/10/2018');
INSERT INTO table CUSTOMERS ('Chandler','Harris','28/10/2018');
INSERT INTO table CUSTOMERS ('Ryan','Humphrey','29/10/2018');
INSERT INTO table CUSTOMERS ('Adara','Richardson','29/10/2018');
INSERT INTO table CUSTOMERS ('Quynn','Madden','01/11/2018');
INSERT INTO table CUSTOMERS ('Brett','Ryan','01/11/2018');
INSERT INTO table CUSTOMERS ('Jessica','Ratliff','26/10/2018');
INSERT INTO table CUSTOMERS ('Nichole','England','31/10/2018');
INSERT INTO table CUSTOMERS ('Octavius','Whitaker','31/10/2018');
INSERT INTO table CUSTOMERS ('Lucius','Mcguire','26/10/2018');
INSERT INTO table CUSTOMERS ('Elizabeth','Joseph','28/10/2018');
INSERT INTO table CUSTOMERS ('Stacy','Gray','28/10/2018');
INSERT INTO table CUSTOMERS ('Germane','Gilmore','26/10/2018');