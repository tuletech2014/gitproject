/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2008-8-2 16:22:50                            */
/*==============================================================*/

--����Ns����ϵͳ���ݿ�
use master

if exists (select *
	    from  sysdatabases
	   where  name = 'NsStorage')
   drop database NsStorage
go

create database NsStorage
go

--Ӧ��Ns�������ݿ�
use NsStorage
go

--����Ns����ϵͳ���ݱ�
if exists (select 1
            from  sysobjects
           where  id = object_id('AfficheInfo')
            and   type = 'U')
   drop table AfficheInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BillInfo')
            and   type = 'U')
   drop table BillInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BillState')
            and   type = 'U')
   drop table BillState
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BranchInfo')
            and   type = 'U')
   drop table BranchInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CargoVector')
            and   type = 'U')
   drop table CargoVector
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CargoInfo')
            and   type = 'U')
   drop table CargoInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CustomerInfo')
            and   type = 'U')
   drop table CustomerInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Department')
            and   type = 'U')
   drop table Department
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DirverInfo')
            and   type = 'U')
   drop table DirverInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('RoleInfo')
            and   type = 'U')
   drop table RoleInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SystemLog')
            and   type = 'U')
   drop table SystemLog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TrafficLog')
            and   type = 'U')
   drop table TrafficLog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TruckInfo')
            and   type = 'U')
   drop table TruckInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TruckLog')
            and   type = 'U')
   drop table TruckLog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TruckModel')
            and   type = 'U')
   drop table TruckModel
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserInfo')
            and   type = 'U')
   drop table UserInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Operation')
            and   type = 'U')
   drop table Operation
go

/*==============================================================*/
/* Table: Operation       �������ӱ�                            */
/*==============================================================*/
create table Operation (
   OpID		        int		    identity,
   OpFID		int		    null,
   OpName		varchar(100)	    null,
   OpUrl		varchar(300)	    null,
   constraint PK_OPERATION primary key (OpID)
)
go

/*==============================================================*/
/* Table: AfficheInfo     վ�ڹ����                            */
/*==============================================================*/
create table AfficheInfo (
   AffichelD            int                  identity,
   UserID               int                  null,
   AfficheTitle         varchar(100)         null,
   AfficheContent       varchar(2000)        null,
   AfficheData          varchar(100)         null,
   BranchID             int                  null,
   constraint PK_AFFICHEINFO primary key (AffichelD)
)
go

/*==============================================================*/
/* Table: BillInfo       ��Ʊ��Ϣ��                             */
/*==============================================================*/
create table BillInfo (
   BillID               int                  identity(100000,1),
   SendID               int                  null,
   ReceiveID            int                  null,
   TruckLine            varchar(100)         null,
   PayerName            varchar(100)         null,
   UserID               int                  null,
   BillData             varchar(100)         null,
   BillStateID          int                  null,
   BillMemo             varchar(500)         null,
   SendBranchID         int                  null,
   ReceiveBranchID	int		     null,
   constraint PK_BILLINFO primary key (BillID)
)
go

/*==============================================================*/
/* Table: BillState       ��Ʊ״̬��                           */
/*==============================================================*/
create table BillState (
   BillStateID          int                  identity(1000,1),
   BillStateName        varchar(100)         null,
   constraint PK_BILLSTATE primary key (BillStateID)
)
go

/*==============================================================*/
/* Table: BranchInfo     �ֹ�˾(�ֿ�)��                         */
/*==============================================================*/
create table BranchInfo (
   BranchID             int                  identity(100,1),
   BranchName           varchar(100)         null,
   BranchLinkMan        varchar(100)         null,
   BranchPhone          varchar(100)         null,
   BranchAddress        varchar(100)         null,
   BranchEmail          varchar(100)         null,
   constraint PK_BRANCHINFO primary key (BranchID)
)
go

/*==============================================================*/
/* Table: CargoInfo      ������Ϣ��                             */
/*==============================================================*/
create table CargoInfo (
   CargoID              int                  identity(1000,1),
   CargoName            varchar(100)         null,
   CargoWeight          varchar(100)         null,
   CargoBulk            varchar(100)         null,
   CargoNum             varchar(100)         null,
   CargoUnit            varchar(100)         null,
   CargoValue           varchar(100)         null,
   CargoFreight         varchar(100)         null,
   CargoAmends          varchar(100)         null,
   CargoMemo            varchar(100)         null,
   CargoState		int		     default 0,
   BranchID             int                  null,
   CargoStartData	varchar(100)	     null,
   CargoEndData		varchar(100)	     null
   constraint PK_CARGOINFO primary key (CargoID)
)
go

/*==============================================================*/
/* Table: CargoVector    ���Ｏ�ϱ�                             */
/*==============================================================*/
create table CargoVector(
   CVID              int                  identity(1000,1),
   CargoID           int		  null,
   BillID            int		  null
   constraint PK_CARGOVECTOR primary key (CVID)
)
go

/*==============================================================*/
/* Table: CustomerInfo    �ͻ���Ϣ��                            */
/*==============================================================*/
create table CustomerInfo (
   CustomerID           int                  identity(1000,1),
   CustomerName         varchar(100)         null,
   CustomerLinkMan      varchar(100)         null,
   CustomerSex          varchar(100)         null,
   CustomerPhone        varchar(100)         null,
   CustomerFax          varchar(100)         null,
   CustomerPostID       varchar(100)         null,
   CustomerEmail        varchar(100)         null,
   CustomerRegData      varchar(100)         null,
   BranchID             int                  null,
   constraint PK_CUSTOMERINFO primary key (CustomerID)
)
go

/*==============================================================*/
/* Table: DepartmentInfo    ������Ϣ��                          */
/*==============================================================*/
create table DepartmentInfo (
   DepartmentID         int                  identity,
   DepartmentName       varchar(100)         null,
   constraint PK_DEPARTMENT primary key (DepartmentID)
)
go

/*==============================================================*/
/* Table: DriverInfo    ˾����Ϣ��                              */
/*==============================================================*/
create table DriverInfo (
   DriverID             int                  identity(1000,1),
   BranchID             int                  null,
   DriverName           varchar(100)         null,
   DriverAge            varchar(100)         null,
   DriverSex            varchar(100)         null,
   DriverPhoto          varchar(100)         null,
   DriverDriveCardID    varchar(100)         null,
   DriverCardID         varchar(100)         null,
   DriverPhone          varchar(100)         null,
   DriverMemo           varchar(500)         null,
   DriverIsVacancy      int                  default 0,
   constraint PK_DIRVERINFO primary key (DriverID)
)
go

/*==============================================================*/
/* Table: RoleInfo     ��ɫ��Ϣ��                               */
/*==============================================================*/
create table RoleInfo (
   RoleID               int                  identity(1000,1),
   RoleName             varchar(100)         null,
   RoleClient           int                  default 0,
   RoleTicket           int                  default 0,
   RoleBranch           int                  default 0,
   RoleTraffic          int                  default 0,
   RoleQuery            int                  default 0,
   RoleBasicInfo        int                  default 0,
   constraint PK_ROLEINFO primary key (RoleID)
)
go

/*==============================================================*/
/* Table: SystemLog    ϵͳ��־��                               */
/*==============================================================*/
create table SystemLog (
   SystemLogID          int                  identity,
   UserID               int                  null,
   SystemLogMemo        varchar(100)         null,
   BranchID             int                  null,
   constraint PK_SYSTEMLOG primary key (SystemLogID)
)
go

/*==============================================================*/
/* Table: TrafficLog    �����¼��(��ϵ��)                      */
/*==============================================================*/
create table TrafficLog (
   TrafficLogID         int                  identity,
   BillID               int                  null,
   TLID                 int                  null,
   BranchID             int                  null,
   constraint PK_TRAFFICLOG primary key (TrafficLogID)
)
go

/*==============================================================*/
/* Table: TruckInfo    ������Ϣ��                               */
/*==============================================================*/
create table TruckInfo (
   TruckID              int                  identity(1000,1),
   TruckNum             varchar(100)         null,
   TruckEngineNum       varchar(100)         null,
   TruckRunNum          varchar(100)         null,
   TruckInsuranceNum    varchar(100)         null,
   TMID                 int                  null,
   TruckColor           varchar(100)         null,
   TruckPhoto           varchar(100)         null,
   TruckBuyData         varchar(100)         null,
   BranchID             int                  null,
   TruckIsVacancy       int                  default 0,
   constraint PK_TRUCKINFO primary key (TruckID)
)
go

/*==============================================================*/
/* Table: TruckLog     ������Ϣ��                               */
/*==============================================================*/
create table TruckLog (
   TLID                 int                  identity(1000,1),
   DriverID             int                  null,
   TruckID              int                  null,
   TLStartData          varchar(100)         null,
   TLArrive             varchar(100)         null,
   BranchID             int                  null,
   constraint PK_TRUCKLOG primary key (TLID)
)
go

/*==============================================================*/
/* Table: TruckModel   �����ͺ���Ϣ��                           */
/*==============================================================*/
create table TruckModel (
   TMID                 int                  identity,
   TMName               varchar(100)         null,
   TMWeight             varchar(100)         null,
   TMCubage             varchar(100)         null,
   TMPassenger          int                  default 2,
   constraint PK_TRUCKMODEL primary key (TMID)
)
go

/*==============================================================*/
/* Table: UserInfo     �û���Ϣ��                               */
/*==============================================================*/
create table UserInfo (
   UserID               int                  identity(10000,1),
   BranchID             int                  null,
   UserName             varchar(100)         null,
   UserRName            varchar(100)         null,
   UserPassword         varchar(100)         null,
   UserSex              varchar(100)         null,
   DepartmentID         int                  null,
   UserPhone            varchar(100)         null,
   UserCardID           varchar(100)         null,
   RoleID               int                  null,
   UserLoginNum         varchar(100)         default 0,
   UserLoginData        varchar(100)         null,
   UserRegData          varchar(100)         null,
   constraint PK_USERINFO primary key (UserID)
)
go

/*==============================================================*/
/* �����������ϵ                                               */
/*==============================================================*/

--�����û���Ϣ����ֹ�˾(�ֿ�)��,���ű��Լ���ɫ��Ϣ��֮����������ϵ
alter table UserInfo add constraint fk_UI_BranchID foreign key (BranchID) references BranchInfo(BranchID)

alter table UserInfo add constraint fk_UI_DepartmentID foreign key (DepartmentID) references DepartmentInfo(DepartmentID)

alter table UserInfo add constraint fk_UI_RoleID foreign key (RoleID) references RoleInfo(RoleID)
go

--�����ͻ���Ϣ����ֹ�˾(�ֿ�)��֮����������ϵ
alter table CustomerInfo add constraint fk_CI_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����������Ϣ���복���ͺ���Ϣ���Լ��ֹ�˾(�ֿ�)��֮����������ϵ
alter table TruckInfo add constraint fk_TI_TMID foreign key (TMID) references TruckModel(TMID)

alter table TruckInfo add constraint fk_TI_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����˾����Ϣ����ֹ�˾(�ֿ�)��֮����������ϵ
alter table DriverInfo add constraint fk_DI_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����������Ϣ����˾����Ϣ��������Ϣ���Լ��ֹ�˾(�ֿ�)��֮����������ϵ
alter table TruckLog add constraint fk_TL_DriverID foreign key (DriverID) references DriverInfo(DriverID)

alter table TruckLog add constraint fk_TL_TruckID foreign key (TruckID) references TruckInfo(TruckID)

alter table TruckLog add constraint fk_TL_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����������Ϣ����ֹ�˾(�ֿ�)��֮����������ϵ
alter table CargoInfo add constraint fk_CargoInfo_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--�������Ｏ�ϱ��������Ϣ��֮����������ϵ
alter table CargoVector add constraint fk_CargoVector_CargoInfo foreign key (CargoID) references CargoInfo(CargoID)
alter table CargoVector add constraint fk_CargoVector_BillInfo foreign key (BillID) references BillInfo(BillID)

--������Ʊ��Ϣ���������Ϣ���ͻ���(�����������ϵ),�û���Ϣ��,��Ʊ״̬���Լ��ֹ�˾(�ֿ�)��(�����������ϵ)֮����������ϵ
alter table BillInfo add constraint fk_BI_SendID foreign key (SendID) references CustomerInfo(CustomerID)

alter table BillInfo add constraint fk_BI_ReceiveID foreign key (ReceiveID) references CustomerInfo(CustomerID)

alter table BillInfo add constraint fk_BI_UserID foreign key (UserID) references UserInfo(UserID)

alter table BillInfo add constraint fk_BI_BillStateID foreign key (BillStateID) references BillState(BillStateID)

alter table BillInfo add constraint fk_BI_SendBranchID foreign key (SendBranchID) references BranchInfo(BranchID)

alter table BillInfo add constraint fk_BI_ReceiveBranchID foreign key (ReceiveBranchID) references BranchInfo(BranchID)
go

--���������¼�����Ʊ��Ϣ��������Ϣ���Ѿ��ֹ�˾(�ֿ�)��֮����������ϵ
alter table TrafficLog add constraint fk_TrafficLog_BillID foreign key (BillID) references BillInfo(BillID)

alter table TrafficLog add constraint fk_TrafficLog_TLID foreign key (TLID) references TruckLog(TLID)

alter table TrafficLog add constraint fk_TrafficLog_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����վ�ڹ�������û���Ϣ���Լ��ֹ�˾(�ֿ�)��֮����������ϵ
alter table AfficheInfo add constraint fk_AI_UserID foreign key (UserID) references UserInfo(UserID)

alter table AfficheInfo add constraint fk_AI_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

--����ϵͳ��־�����û���Ϣ���Լ��ֹ�˾(�ֿ�)��֮����������ϵ
alter table SystemLog add constraint fk_SL_UserID foreign key (UserID) references UserInfo(UserID)

alter table SystemLog add constraint fk_SL_BranchID foreign key (BranchID) references BranchInfo(BranchID)
go

/*==============================================================*/
/* ���ϵͳ������Ϣ                                             */
/*==============================================================*/

--��Ӳ������ӱ���Ϣ
insert into Operation values(0,'�ͻ�����','http://localhost:8080/prjNsLogistics/#')
insert into Operation values(0,'�ֿ����','http://localhost:8080/prjNsLogistics/#')
insert into Operation values(0,'��������','http://localhost:8080/prjNsLogistics/#')
insert into Operation values(0,'�ۺϲ�ѯ','http://localhost:8080/prjNsLogistics/#')
insert into Operation values(0,'ϵͳ����','http://localhost:8080/prjNsLogistics/#')
insert into Operation values(0,'�ֹ�˾ҵ��ͳ��','../jfreeCharBranch.do')

insert into Operation values(1,'�ͻ�¼��','../Yasak/Yasak_CustomerInfo.html')
insert into Operation values(1,'�ͻ���ѯ','../Mars/CustomerResult.html')
insert into Operation values(1,'����ҵ��','../Yasak/BillInfo.html')
insert into Operation values(1,'ҵ�����','../Yasak/MainTags.html')
insert into Operation values(1,'���淢��','../Yasak/Affiche.html')

insert into Operation values(2,'������Ϣ�б�','../Moster/MoCargoList.html')
insert into Operation values(2,'���Ｏ���б�','../Moster/MoCargoVCList.html')
insert into Operation values(2,'���ǩ��','../Moster/MoBillList.html')
insert into Operation values(2,'��������','../Moster/MoTraBillList.html')
insert into Operation values(2,'������','../Moster/MoBillCheckList.html')
insert into Operation values(2,'���ȷּ�','../Moster/MoSortingBillList.html')
insert into Operation values(2,'�ֿ����','CargoTidy.html')
insert into Operation values(2,'�ֿ��ѯ','../Moster/MoCargoSelectList.html')

insert into Operation values(3,'���ȹ���','TruckInfo.html')
insert into Operation values(3,'���Ȳ�ѯ','../Mars/BillshareResult.html')

insert into Operation values(4,'�ͻ���ѯ','../Mars/CustomerResult.html')
insert into Operation values(4,'�ֿ��ѯ','../Mars/BranchResult.html')
insert into Operation values(4,'���Ȳ�ѯ','../Mars/BillshareResult.html')
insert into Operation values(4,'������ѯ','../Mars/TruckResult.html')
insert into Operation values(4,'��Ա��ѯ','../Mars/UserResult.html')
insert into Operation values(4,'˾����ѯ','../Mars/DriverResult.html')
insert into Operation values(4,'ҵ���ѯ','../Mars/BillsResult.html')
insert into Operation values(4,'�ͻ�ͳ��','../jfreeCharCustomer.do')

insert into Operation values(5,'�����ͺŹ���','../Carmack/TruckModel.html')
insert into Operation values(5,'������Ϣ����','../Carmack/TruckInfo.html')
insert into Operation values(5,'Ա����Ϣ����','../Carmack/UserInfo.html')
insert into Operation values(5,'˾����Ϣ����','../Carmack/DriverInfo.html')
insert into Operation values(5,'��˾��Ϣ����','../Carmack/BranchInfo.html')
insert into Operation values(5,'ϵͳ��־�鿴','../Carmack/SystemLog.html')


--��ӽ�ɫ��Ϣ����Ϣ
insert into RoleInfo values('��������Ա',1,1,1,1,1,1)
insert into RoleInfo values('�ͻ�������Ա',1,0,0,0,0,0)
insert into RoleInfo values('�ֿ������Ա',0,0,1,0,0,0)
insert into RoleInfo values('���͹�����Ա',0,0,0,1,0,0)
insert into RoleInfo values('����',1,1,1,1,1,1)
insert into RoleInfo values('ҵ�񶽲���Ա',0,0,0,0,1,0)
go

--��ӷֹ�˾(�ֿ�)����Ϣ
insert into BranchInfo values('ʢ������','���','01086030618','�����г�����211��','opt-China@163.com')
insert into BranchInfo values('���ǲִ�����','������','03516030618','ɽ��ʡ̫ԭ��ӭ����211��','opt-Taiyuan@163.com')
insert into BranchInfo values('�ųǲִ�����','��Ρ','02985855485','����ʡ�����й⻪·211��','opt-Xian@163.com')
insert into BranchInfo values('�����زִ�����','�Ա�ɽ','04316031679','����ʡ������������211��','opt-Changchun@163.com')
insert into BranchInfo values('�����ִ�����','��Ѹ','05707025888','�㽭����ʯ��·211��','opt-Hangzhou@163.com')
insert into BranchInfo values('�츮�ִ�����','�����','02875241156','�Ĵ�ʡ�ɶ��н�Ȫ·211��','opt-Chengdu@163.com')
insert into BranchInfo values('�޲����ִ�����','���','09716031188','�ຣʡ�������Ϲؽ�211��','opt-Qinghai@163.com')
go

--��ӹ�˾���ű���Ϣ
insert into DepartmentInfo values('�ͷ���')
insert into DepartmentInfo values('�ִ���')
insert into DepartmentInfo values('���Ͳ�')
insert into DepartmentInfo values('����칫��')
insert into DepartmentInfo values('����')
go

--����û���Ϣ����Ϣ
insert into UserInfo values(101,'admin','����','123','��',5,'13572275851','14010819580603195x',1000,'0','2008-08-01','2008-08-02')
insert into UserInfo values(101,'client','ҵ��Ա','123','��',1,'13572275852','14010819580604195x',1001,'0','2008-08-01','2008-08-02')
insert into UserInfo values(101,'branch','�����','123','��',2,'13572275854','14010819580606195x',1002,'0','2008-08-01','2008-08-02')
insert into UserInfo values(101,'traffic','������','123','��',3,'13572275855','14010819580607195x',1003,'0','2008-08-01','2008-08-02')
insert into UserInfo values(101,'manager','����','123','��',4,'13572275856','14010819580608195x',1004,'0','2008-08-01','2008-08-02')
insert into UserInfo values(100,'oversee','�ܹ�˾����','123','��',5,'13572275857','14010819580609195x',1005,'0','2008-08-01','2008-08-02')
go

--��ӿͻ���Ϣ����Ϣ
insert into CustomerInfo values('ͻ����ҵ����','ͻ����','��','07328726394','07328726395','410000','TuJv@163.com','2008-08-02',101)
insert into CustomerInfo values('ԽŮ���������','���˷�','Ů','03728726394','03728726395','140000','Yvnv@163.com','2008-08-02',101)
insert into CustomerInfo values('ͬ����ջ','١����','Ů','0298726394','0298726395','710000','Tfkz@163.com','2008-08-02',101)
insert into CustomerInfo values('��ͬ����ջ','��١��','Ů','0298726394','0298726395','710000','Tfkz@163.com','2008-08-02',101)
insert into CustomerInfo values('�����±��ڹ�˾','���ذ�','��','0298726394','0298726395','170000','Mjs@163.com','2008-08-02',101)
insert into CustomerInfo values('ͬ������ջ','١����','Ů','0298726394','0298726395','710000','Tfkz@163.com','2008-08-02',101)
insert into CustomerInfo values('ͬ������ջ','����١','Ů','0298726394','0298726395','710000','Tfkz@163.com','2008-08-02',101)
go

--��ӻ�����Ϣ����Ϣ
insert into CargoInfo values('������Ʒѵ����','5','50','100','1','240','8000','2000','�ļ�ѵ��','0',101,'20080817','')
insert into CargoInfo values('���ڲ��ӵ�����','5','50','100','1','240','8000','2000','�ó�','0',101,'20080817','')
insert into CargoInfo values('֣��սѥ','5','50','100','1','240','8000','2000','���','0',101,'20080817','')
insert into CargoInfo values('���˸���','5','50','100','1','240','8000','2000','������','0',101,'20080817','')
insert into CargoInfo values('�����ߺ�','5','50','100','1','240','8000','2000','�ö���','0',101,'20080817','')
insert into CargoInfo values('�����','5','50','100','1','240','8000','2000','����','0',101,'20080817','')
insert into CargoInfo values('��ũ��','5','50','100','1','240','8000','2000','����','0',101,'20080817','')
insert into CargoInfo values('��ԯ��','5','50','100','1','240','8000','2000','����','0',101,'20080817','')
insert into CargoInfo values('������Ѩ��ͼ��','5','50','100','1','240','8000','2000','�书����','0',101,'20080817','')
insert into CargoInfo values('�����⴫�ܱ�','5','50','100','1','240','8000','2000','�����ܱ�','0',101,'20080817','')
insert into CargoInfo values('����ơ��','5','50','100','1','240','8000','2000','�ú�','0',101,'20080817','')
go

--��ӻ�Ʊ״̬����Ϣ
insert into BillState values('Send_�ͷ��ѽӵ�,�ȴ����')
insert into BillState values('Send_�����ȷ��')
insert into BillState values('Send_���������ϣ��ȴ�����')
insert into BillState values('Send_����װ�����,���ѷ���')
insert into BillState values('Receive_���ѵ���,δǩ��')
insert into BillState values('Receive_����ǩ��,δ���')
insert into BillState values('Receive_�ּ����,�����')
insert into BillState values('Receive_�ͷ�֪ͨ�ͻ�,�ȴ����')
insert into BillState values('Receive_�ͻ�����,�������')
go

--��ӻ�Ʊ��Ϣ����Ϣ
insert into BillInfo values(1000,1001,'̫ԭ-����','��ȱ',10000,'20080816',1001,'�Ʊ�֮��',101,105)
go

--��ӻ��Ｏ�ϱ���Ϣ
insert into CargoVector values(1000,100000)
insert into CargoVector values(1001,100000)
insert into CargoVector values(1002,100000)
insert into CargoVector values(1003,100000)
go

--��ӳ����ͺ���Ϣ����Ϣ
insert into TruckModel values('������Kamaz','40','80',3)
insert into TruckModel values('̫����Tatra','30','70',2)
insert into TruckModel values('���Faw','25','65',2)
insert into TruckModel values('����Foton','15','40',1)
go

--��ӳ�����Ϣ����Ϣ
insert into TruckInfo values('��A00286','KA4837448936','86999','ST597896777',1,'��ɫ','http://localhost:8000/update/photo/car/xxx','2008-07-13',101,0)
insert into TruckInfo values('��A00287','TT4837448936','87000','ST597896778',2,'��ɫ','http://localhost:8000/update/photo/car/xxx','2008-07-13',101,0)
insert into TruckInfo values('��A00288','Fa4837448936','87001','ST597896779',3,'��ɫ','http://localhost:8000/update/photo/car/xxx','2008-07-13',101,0)
insert into TruckInfo values('��A00289','FO4837448936','87002','ST597896780',4,'��ɫ','http://localhost:8000/update/photo/car/xxx','2008-07-13',101,0)
go

--���˾����Ϣ����Ϣ
insert into DriverInfo values(101,'ղķ˹���','35','��','http://localhost:8000/update/photo/driver/xxx','DC140108198506031952','140108198506031952','13575578547','�ؼ���ʻԱ',0)
insert into DriverInfo values(101,'С���','34','��','http://localhost:8000/update/photo/driver/xxx','DC140108198506031953','140108198506031953','13575578548','�ؼ���ʻԱ',0)
insert into DriverInfo values(101,'����','24','��','http://localhost:8000/update/photo/driver/xxx','DC140108198506031954','140108198506031954','13575578549','�ؼ���ʻԱ',0)
go

--��ӹ�����Ϣ����Ϣ
insert into AfficheInfo values(10000,'���Ŵ�','������ף�����ھֿ�ҵ�󼪣�','20080803',101)
insert into AfficheInfo values(10000,'��ӭ�¿ͻ�','���һ�ӭͻ����ҵ��Ϊ�ҹ�˾��һλ�ͻ���','20080803',101)
insert into AfficheInfo values(10000,'��ӭ�¿ͻ�','���һ�ӭԽŮ����ҵ��Ϊ�ҹ�˾�ڶ�λ�ͻ���','20080804',101)
insert into AfficheInfo values(10000,'��ӭ�¿ͻ�','���һ�ӭͬ����ջ��Ϊ�ҹ�˾����λ�ͻ���','20080805',101)
insert into AfficheInfo values(10000,'��ӭ�¿ͻ�','���һ�ӭ��ͬ����ջ��Ϊ�ҹ�˾����λ�ͻ���','20080806',101)
insert into AfficheInfo values(10000,'���˺Ȳ�','������ף�������˻ῪĻ','20080808',101)
insert into AfficheInfo values(10000,'�׽���','����Ů�Ӿ��ض�Ϊ�й����˴�����¶��׽�','20080809',101)
insert into AfficheInfo values(10000,'�۰԰��˽��ư�','�й����˴�������ѹ�ڶྡྷ���ڽ��ư��ж�ռ��ͷ','20080810',101)
insert into AfficheInfo values(10000,'ͻ��100','��֮ȭ�����Ƶĵ������ҹ����˾����Ѿ�Ϊ����¶�100ö���˽���','20080824',101)
go

/*==============================================================*/
/* ��ѯ���ݿ�������Ϣ                                           */
/*==============================================================*/
select * from UserInfo
select * from RoleInfo
select * from BranchInfo
select * from DepartmentInfo
select * from CustomerInfo
select * from TruckModel
select * from TruckInfo
select * from DriverInfo
select * from TruckLog
select * from CargoInfo
select * from BillState
select * from BillInfo
select * from TrafficLog
select * from AfficheInfo
select * from CargoVector
select * from SystemLog
select * from Operation
go










