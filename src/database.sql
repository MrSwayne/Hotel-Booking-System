-- Table: Guests
CREATE TABLE IF NOT EXISTS Guests (
    Gid int  NOT NULL AUTO_INCREMENT,
    first_name varchar(40)  NOT NULL,
    last_name varchar(40)  NOT NULL,
    member_since date  DEFAULT (current_date),
    TotalSpent int  DEFAULT 0,
    MembershipLevel int DEFAULT 0,
    PRIMARY KEY (Gid)
);

-- Table: bookings
CREATE TABLE IF NOT EXISTS bookings (
    Bid int  NOT NULL AUTO_INCREMENT,
    date_in date  NOT NULL,
    date_out date  NOT NULL,
    Gid int  NOT NULL,
    Rid int  NOT NULL,
    PRIMARY KEY (Bid),
    FOREIGN KEY (Gid) REFERENCES Guests(Gid),
    FOREIGN KEY (Rid) REFERENCES Rooms(Rid)
);

-- Table: hotels
CREATE TABLE IF NOT EXISTS hotels (
    Hid int  NOT NULL AUTO_INCREMENT,
    Name varchar(40)  NOT NULL,
    Country varchar(40)  NOT NULL,
    City varchar(40)  NOT NULL,
    Rooms int  DEFAULT 0,
    PRIMARY KEY (Hid)
);

-- Table: payments
CREATE TABLE IF NOT EXISTS payments (
    Pid int  NOT NULL AUTO_INCREMENT,
    IsPaid boolean  NOT NULL,
    TotalPrice int  NOT NULL,
    Bid int  NOT NULL,
    PRIMARY KEY (Pid),
    FOREIGN KEY (Bid) REFERENCES bookings(Bid)
);

-- Table: rooms
CREATE TABLE IF NOT EXISTS rooms (
    Rid int  NOT NULL AUTO_INCREMENT,
    Rnumber int  NOT NULL,
    Type varchar(40)  NOT NULL,
    Status varchar(10)  NOT NULL,
    Price int  DEFAULT 0,
    Hid int  NOT NULL,
    PRIMARY KEY (Rid),
    FOREIGN KEY (Hid) REFERENCES hotels(Hid)
);

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    Uid int  NOT NULL AUTO_INCREMENT,
    FirstName varchar(40)  NOT NULL,
    LastName varchar(40)  NOT NULL,
    IsManager boolean  NOT NULL,
    Password varchar(40)  NOT NULL,
    PRIMARY KEY (Uid),
);

INSERT INTO table Guests ('Vera','Irwin','29/10/2018');
INSERT INTO table Guests ('Erica','Valenzuela','30/10/2018');
INSERT INTO table Guests ('Oscar','Valencia','31/10/2018');
INSERT INTO table Guests ('Quin','Barrera','28/10/2018');
INSERT INTO table Guests ('Len','Moss','26/10/2018');
INSERT INTO table Guests ('Ina','Deleon','31/10/2018');
INSERT INTO table Guests ('Fredericka','Olsen','27/10/2018');
INSERT INTO table Guests ('Upton','Graves','27/10/2018');
INSERT INTO table Guests ('Hyatt','Petersen','27/10/2018');
INSERT INTO table Guests ('Charissa','Dale','26/10/2018');
INSERT INTO table Guests ('Elvis','Farrell','26/10/2018');
INSERT INTO table Guests ('Hiram','Edwards','29/10/2018');
INSERT INTO table Guests ('Miriam','Short','29/10/2018');
INSERT INTO table Guests ('Harding','Sosa','28/10/2018');
INSERT INTO table Guests ('Illiana','Cross','30/10/2018');
INSERT INTO table Guests ('Hasad','Carey','26/10/2018');
INSERT INTO table Guests ('Victor','Santos','01/11/2018');
INSERT INTO table Guests ('Magee','Tanner','28/10/2018');
INSERT INTO table Guests ('Ali','Vazquez','28/10/2018');
INSERT INTO table Guests ('Rahim','Kelley','29/10/2018');
INSERT INTO table Guests ('Latifah','Estrada','30/10/2018');
INSERT INTO table Guests ('Prescott','Fields','31/10/2018');
INSERT INTO table Guests ('Duncan','Finch','31/10/2018');
INSERT INTO table Guests ('Brandon','Wilkins','30/10/2018');
INSERT INTO table Guests ('Melyssa','Hull','30/10/2018');
INSERT INTO table Guests ('Knox','Hester','31/10/2018');
INSERT INTO table Guests ('Otto','Meadows','28/10/2018');
INSERT INTO table Guests ('Nina','Dickerson','01/11/2018');
INSERT INTO table Guests ('Tiger','Clarke','26/10/2018');
INSERT INTO table Guests ('Ginger','Michael','28/10/2018');
INSERT INTO table Guests ('Finn','Prince','30/10/2018');
INSERT INTO table Guests ('Owen','Rios','27/10/2018');
INSERT INTO table Guests ('Hyacinth','Hudson','28/10/2018');
INSERT INTO table Guests ('Justina','Petersen','01/11/2018');
INSERT INTO table Guests ('Brianna','Mcconnell','27/10/2018');
INSERT INTO table Guests ('Shana','Garrison','29/10/2018');
INSERT INTO table Guests ('Odessa','Allison','01/11/2018');
INSERT INTO table Guests ('Rana','Whitley','26/10/2018');
INSERT INTO table Guests ('Zeph','Faulkner','30/10/2018');
INSERT INTO table Guests ('Hedy','Sloan','27/10/2018');
INSERT INTO table Guests ('Ocean','Allen','26/10/2018');
INSERT INTO table Guests ('Jonah','Conway','29/10/2018');
INSERT INTO table Guests ('Jaime','Cobb','30/10/2018');
INSERT INTO table Guests ('Dante','Landry','01/11/2018');
INSERT INTO table Guests ('Grady','Lynch','01/11/2018');
INSERT INTO table Guests ('Christian','Wiggins','28/10/2018');
INSERT INTO table Guests ('Oscar','Green','01/11/2018');
INSERT INTO table Guests ('Cedric','Chavez','29/10/2018');
INSERT INTO table Guests ('Amity','Jensen','29/10/2018');
INSERT INTO table Guests ('Lavinia','Hale','28/10/2018');
INSERT INTO table Guests ('Kevin','Mcintosh','31/10/2018');
INSERT INTO table Guests ('Caesar','Buck','29/10/2018');
INSERT INTO table Guests ('Megan','Boyer','31/10/2018');
INSERT INTO table Guests ('Imelda','Forbes','30/10/2018');
INSERT INTO table Guests ('Anastasia','Goodman','29/10/2018');
INSERT INTO table Guests ('Demetria','Giles','27/10/2018');
INSERT INTO table Guests ('Alika','Dorsey','01/11/2018');
INSERT INTO table Guests ('Marvin','Rojas','26/10/2018');
INSERT INTO table Guests ('Quinlan','Parker','31/10/2018');
INSERT INTO table Guests ('Tashya','Marks','27/10/2018');
INSERT INTO table Guests ('Inez','Leblanc','01/11/2018');
INSERT INTO table Guests ('Veda','Oneal','01/11/2018');
INSERT INTO table Guests ('Mason','Nelson','31/10/2018');
INSERT INTO table Guests ('Keegan','Brock','01/11/2018');
INSERT INTO table Guests ('Beau','Adkins','28/10/2018');
INSERT INTO table Guests ('Kamal','Hodges','26/10/2018');
INSERT INTO table Guests ('Britanni','Hall','29/10/2018');
INSERT INTO table Guests ('Hedy','Page','31/10/2018');
INSERT INTO table Guests ('Omar','Pace','01/11/2018');
INSERT INTO table Guests ('Mufutau','Blair','27/10/2018');
INSERT INTO table Guests ('Neil','Pierce','30/10/2018');
INSERT INTO table Guests ('Mary','Williams','01/11/2018');
INSERT INTO table Guests ('Sylvia','Klein','27/10/2018');
INSERT INTO table Guests ('August','Fry','01/11/2018');
INSERT INTO table Guests ('Jackson','Kidd','28/10/2018');
INSERT INTO table Guests ('Keely','Chen','30/10/2018');
INSERT INTO table Guests ('Dai','Thornton','26/10/2018');
INSERT INTO table Guests ('Carl','Burt','30/10/2018');
INSERT INTO table Guests ('Hollee','Day','27/10/2018');
INSERT INTO table Guests ('Alexander','Bishop','28/10/2018');
INSERT INTO table Guests ('Hyatt','Goodwin','31/10/2018');
INSERT INTO table Guests ('Kennedy','French','27/10/2018');
INSERT INTO table Guests ('Nathaniel','Wells','26/10/2018');
INSERT INTO table Guests ('Travis','Barnes','30/10/2018');
INSERT INTO table Guests ('Wesley','Hickman','26/10/2018');
INSERT INTO table Guests ('Risa','Hutchinson','27/10/2018');
INSERT INTO table Guests ('Alden','Barrett','30/10/2018');
INSERT INTO table Guests ('Declan','Gallagher','29/10/2018');
INSERT INTO table Guests ('Megan','Kent','27/10/2018');
INSERT INTO table Guests ('Venus','Anderson','01/11/2018');
INSERT INTO table Guests ('Marsden','Puckett','26/10/2018');
INSERT INTO table Guests ('Rajah','Cruz','27/10/2018');
INSERT INTO table Guests ('Zane','Rodgers','30/10/2018');
INSERT INTO table Guests ('Joseph','Long','28/10/2018');
INSERT INTO table Guests ('Whilemina','Burnett','30/10/2018');
INSERT INTO table Guests ('Jael','Cantrell','30/10/2018');
INSERT INTO table Guests ('Gary','Weiss','31/10/2018');
INSERT INTO table Guests ('Buffy','Reid','31/10/2018');
INSERT INTO table Guests ('Hoyt','Acevedo','31/10/2018');
INSERT INTO table Guests ('Felix','Thomas','01/11/2018');
INSERT INTO table Guests ('Aristotle','Emerson','28/10/2018');
INSERT INTO table Guests ('Fredericka','Mcmahon','29/10/2018');
INSERT INTO table Guests ('Barry','Garza','27/10/2018');
INSERT INTO table Guests ('Virginia','Mullen','28/10/2018');
INSERT INTO table Guests ('William','Bean','28/10/2018');
INSERT INTO table Guests ('Shana','Fox','30/10/2018');
INSERT INTO table Guests ('Cleo','Elliott','28/10/2018');
INSERT INTO table Guests ('Mannix','Stanley','31/10/2018');
INSERT INTO table Guests ('Wesley','Heath','26/10/2018');
INSERT INTO table Guests ('Malcolm','Daugherty','30/10/2018');
INSERT INTO table Guests ('Yardley','Clemons','28/10/2018');
INSERT INTO table Guests ('Nora','Gallagher','01/11/2018');
INSERT INTO table Guests ('Justin','Mccarty','31/10/2018');
INSERT INTO table Guests ('Kai','George','27/10/2018');
INSERT INTO table Guests ('Daniel','Buck','31/10/2018');
INSERT INTO table Guests ('Mira','Cain','30/10/2018');
INSERT INTO table Guests ('Robert','Fuller','31/10/2018');
INSERT INTO table Guests ('Abraham','Keith','27/10/2018');
INSERT INTO table Guests ('Ezekiel','Bailey','30/10/2018');
INSERT INTO table Guests ('Florence','Baldwin','27/10/2018');
INSERT INTO table Guests ('Hammett','Marquez','28/10/2018');
INSERT INTO table Guests ('Kareem','Reed','26/10/2018');
INSERT INTO table Guests ('Martina','Mercer','01/11/2018');
INSERT INTO table Guests ('Camille','Cleveland','01/11/2018');
INSERT INTO table Guests ('Flavia','Williamson','28/10/2018');
INSERT INTO table Guests ('Jolie','Cook','26/10/2018');
INSERT INTO table Guests ('Bertha','Parsons','30/10/2018');
INSERT INTO table Guests ('Raphael','Holcomb','30/10/2018');
INSERT INTO table Guests ('Nero','Salazar','31/10/2018');
INSERT INTO table Guests ('Darrel','Ballard','30/10/2018');
INSERT INTO table Guests ('Xenos','Berger','01/11/2018');
INSERT INTO table Guests ('Keefe','Buck','28/10/2018');
INSERT INTO table Guests ('Cally','Brady','28/10/2018');
INSERT INTO table Guests ('Brooke','Burris','30/10/2018');
INSERT INTO table Guests ('Clio','Boyer','31/10/2018');
INSERT INTO table Guests ('Christen','Greene','27/10/2018');
INSERT INTO table Guests ('Owen','Massey','30/10/2018');
INSERT INTO table Guests ('Wang','Leon','31/10/2018');
INSERT INTO table Guests ('Marsden','Evans','28/10/2018');
INSERT INTO table Guests ('Joel','Ray','31/10/2018');
INSERT INTO table Guests ('Oren','Alford','01/11/2018');
INSERT INTO table Guests ('Bree','Gentry','27/10/2018');
INSERT INTO table Guests ('Cynthia','Martin','29/10/2018');
INSERT INTO table Guests ('Aristotle','Price','31/10/2018');
INSERT INTO table Guests ('Jackson','Stephens','01/11/2018');
INSERT INTO table Guests ('Ori','Wynn','01/11/2018');
INSERT INTO table Guests ('Eagan','Guerrero','27/10/2018');
INSERT INTO table Guests ('Gillian','Holland','26/10/2018');
INSERT INTO table Guests ('Emerson','Vazquez','01/11/2018');
INSERT INTO table Guests ('Fredericka','Velez','27/10/2018');
INSERT INTO table Guests ('Lewis','Wright','28/10/2018');
INSERT INTO table Guests ('Wing','Fields','31/10/2018');
INSERT INTO table Guests ('Hanna','Beach','31/10/2018');
INSERT INTO table Guests ('Myles','Gordon','27/10/2018');
INSERT INTO table Guests ('Irma','Lee','29/10/2018');
INSERT INTO table Guests ('Abdul','Rogers','29/10/2018');
INSERT INTO table Guests ('Kyle','Holden','26/10/2018');
INSERT INTO table Guests ('Selma','Peters','26/10/2018');
INSERT INTO table Guests ('Dominic','Golden','29/10/2018');
INSERT INTO table Guests ('Neville','Hill','28/10/2018');
INSERT INTO table Guests ('Barbara','Sparks','01/11/2018');
INSERT INTO table Guests ('Rebekah','Hanson','27/10/2018');
INSERT INTO table Guests ('Anjolie','Rush','28/10/2018');
INSERT INTO table Guests ('Curran','Haynes','27/10/2018');
INSERT INTO table Guests ('Emi','Lamb','29/10/2018');
INSERT INTO table Guests ('Judith','Oneil','26/10/2018');
INSERT INTO table Guests ('Kiara','Maldonado','28/10/2018');
INSERT INTO table Guests ('Phoebe','Sloan','29/10/2018');
INSERT INTO table Guests ('Ruby','Collier','28/10/2018');
INSERT INTO table Guests ('Camille','Hanson','28/10/2018');
INSERT INTO table Guests ('Otto','Campbell','26/10/2018');
INSERT INTO table Guests ('William','Byrd','26/10/2018');
INSERT INTO table Guests ('Mechelle','Todd','28/10/2018');
INSERT INTO table Guests ('Emery','Reyes','28/10/2018');
INSERT INTO table Guests ('Amity','Conway','28/10/2018');
INSERT INTO table Guests ('Xanthus','Gilmore','26/10/2018');
INSERT INTO table Guests ('Harriet','Craft','31/10/2018');
INSERT INTO table Guests ('Angela','Sherman','29/10/2018');
INSERT INTO table Guests ('Jaime','Murray','27/10/2018');
INSERT INTO table Guests ('Urielle','Frazier','01/11/2018');
INSERT INTO table Guests ('Francesca','Reynolds','26/10/2018');
INSERT INTO table Guests ('Murphy','Conner','27/10/2018');
INSERT INTO table Guests ('Chanda','Shepard','01/11/2018');
INSERT INTO table Guests ('Wylie','Knapp','28/10/2018');
INSERT INTO table Guests ('Josephine','Buckley','30/10/2018');
INSERT INTO table Guests ('Mollie','Shepard','31/10/2018');
INSERT INTO table Guests ('Astra','Olson','30/10/2018');
INSERT INTO table Guests ('Asher','Albert','29/10/2018');
INSERT INTO table Guests ('Chandler','Harris','28/10/2018');
INSERT INTO table Guests ('Ryan','Humphrey','29/10/2018');
INSERT INTO table Guests ('Adara','Richardson','29/10/2018');
INSERT INTO table Guests ('Quynn','Madden','01/11/2018');
INSERT INTO table Guests ('Brett','Ryan','01/11/2018');
INSERT INTO table Guests ('Jessica','Ratliff','26/10/2018');
INSERT INTO table Guests ('Nichole','England','31/10/2018');
INSERT INTO table Guests ('Octavius','Whitaker','31/10/2018');
INSERT INTO table Guests ('Lucius','Mcguire','26/10/2018');
INSERT INTO table Guests ('Elizabeth','Joseph','28/10/2018');
INSERT INTO table Guests ('Stacy','Gray','28/10/2018');
INSERT INTO table Guests ('Germane','Gilmore','26/10/2018');

INSERT INTO TABLE USERS ('Caolan','McDonagh',TRUE,'nana');
INSERT INTO TABLE USERS ('Ian','Duggan',FALSE,'devops');
INSERT INTO TABLE USERS ('Adam','Swayne',TRUE,'Apple1');
INSERT INTO TABLE USERS ('Sabina','Taddei',FALSE,'MIA');
INSERT INTO TABLE USERS ('Patryk','Marczak',FALSE,'easy');

INSERT INTO TABLE HOTELS ('The Swayne','Netherlands','Amsterdam',70);
INSERT INTO TABLE HOTELS ('The Duggans','Ireland','Galway',50);
INSERT INTO TABLE HOTELS ('The McDonaghs','Iceland','Reykjavik',25);
INSERT INTO TABLE HOTELS ('The Taddeis','Italy','Rome',150);
INSERT INTO TABLE HOTELS ('The Marczaks','Japan','Kyoto',200);
INSERT INTO TABLE HOTELS ('Azure Hotel','Germany','Berlin',120);
INSERT INTO TABLE HOTELS ('Sapphire Hotel','England','London',300);
INSERT INTO TABLE HOTELS ('Bronze Motel','France','Lyon',80);
INSERT INTO TABLE HOTELS ('Stellar Hotel','Spain','Barcelona',110);
INSERT INTO TABLE HOTELS ('Atlantic Hotel','Portugal','Lisbon',60);
INSERT INTO TABLE HOTELS ('Drizzle Hotel','USA','New York',500);
