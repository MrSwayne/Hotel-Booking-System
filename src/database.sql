/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table "Customer" (
   LastName             nvarchar(40)         not null,
   FirstName            nvarchar(40)         not null,
   Email                nvarchar(40)         null,
   City                 nvarchar(40)         null,
   Country              nvarchar(40)         null,
   constraint PK_CUSTOMER primary key (Id)
)
go

/*==============================================================*/
/* Index: IndexCustomerName                                     */
/*==============================================================*/
create index IndexCustomerName on Customer (
LastName ASC,
FirstName ASC
)
go

/*==============================================================*/
/* Table: "Hotels"                                              */
/*==============================================================*/
create table "Hotels" (
   Name           		nvarchar(40)         null,
   City          		nvarchar(40)         null,
   Country           	nvarchar(40)         null,
)
go

/*==============================================================*/
/* Table: "Rooms"                                               */
/*==============================================================*/
create table "Rooms" (
   RoomNumber           int                  null,
   RoomType             nvarchar(10)         null,
)
go

/*==============================================================*/
/* Table: "Users"                                               */
/*==============================================================*/
create table "Users" (
   Id                   int                  identity,
   LastName             nvarchar(40)         not null,
   FirstName            nvarchar(40)         not null,
   Manager           	bit                  null,
   PRIMARY KEY (Id)
)
go

/*==============================================================*/
/* Table: "Bookings"                                            */
/*==============================================================*/
create table "Bookings" (

/* Need to discuss this and Payments together.*/

)
go

/*==============================================================*/
/* Table: "Payments"                                            */
/*==============================================================*/
create table "Payments" (


)
go