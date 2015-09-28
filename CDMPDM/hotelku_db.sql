/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     9/27/2015 2:03:19 AM                         */
/*==============================================================*/


drop table if exists DESTINASI_TEMPAT_WISATA;

drop table if exists FASILITAS;

drop table if exists FASILITAS_KAMAR;

drop table if exists GBR_DESTINASI;

drop table if exists GBR_PROPERTI;

drop table if exists HUNTING_GROUND;

drop table if exists INFO_DESTINASI;

drop table if exists JENIS_KELAMIN;

drop table if exists JENIS_WISATA;

drop table if exists KAMAR;

drop table if exists NEGARA;

drop table if exists NOTIF_PROPERTI;

drop table if exists NOTIF_TURIS;

drop table if exists OWNER;

drop table if exists PEMESANAN;

drop table if exists PROPERTI;

drop table if exists REVIEW;

drop table if exists STATUS_PERNIKAHAN;

drop table if exists TMPT_MENARIK;

drop table if exists TURIS;

/*==============================================================*/
/* Table: DESTINASI_TEMPAT_WISATA                               */
/*==============================================================*/
create table DESTINASI_TEMPAT_WISATA
(
   DEST_WISATA_ID       int not null auto_increment,
   JENIS_WISATA_ID      int,
   DEST_ID              int,
   DEST_WISATA_NAMA     varchar(20),
   DEST_WISATA_TEMPAT   varchar(25),
   DEST_WISATA_KETERANGAN varchar(3000),
   DEST_WISATA_GAMBAR   varchar(500),
   primary key (DEST_WISATA_ID)
);

/*==============================================================*/
/* Table: FASILITAS                                             */
/*==============================================================*/
create table FASILITAS
(
   FASILITAS_ID         int not null,
   FASILITAS_JENIS      varchar(50) not null,
   primary key (FASILITAS_ID)
);

/*==============================================================*/
/* Table: FASILITAS_KAMAR                                       */
/*==============================================================*/
create table FASILITAS_KAMAR
(
   FASILITAS_KAMAR_ID   int not null,
   FASILITAS_KAMAR_JENIS varchar(100),
   primary key (FASILITAS_KAMAR_ID)
);

/*==============================================================*/
/* Table: GBR_DESTINASI                                         */
/*==============================================================*/
create table GBR_DESTINASI
(
   GBR_ID               varchar(100) not null,
   DEST_ID              int,
   GBR_DETAIL           varchar(500) not null,
   primary key (GBR_ID)
);

/*==============================================================*/
/* Table: GBR_PROPERTI                                          */
/*==============================================================*/
create table GBR_PROPERTI
(
   GBR_PROP_ID          int not null,
   PROPERTI_ID          int,
   GBR_PROP_DETAIL      varchar(500) not null,
   primary key (GBR_PROP_ID)
);

/*==============================================================*/
/* Table: HUNTING_GROUND                                        */
/*==============================================================*/
create table HUNTING_GROUND
(
   HUNT_ID              int not null,
   TURIS_ID             int,
   HUNT_BUDGET          int not null,
   HUNT_TGL             date not null,
   HUNT_JML_KMR         int not null,
   HUNT_JML_ORG         int not null,
   HUNT_JML_MLM         int not null,
   HUNT_LOKASI          varchar(20) not null,
   primary key (HUNT_ID)
);

/*==============================================================*/
/* Table: INFO_DESTINASI                                        */
/*==============================================================*/
create table INFO_DESTINASI
(
   DEST_ID              int not null,
   DEST_NAMA            varchar(20) not null,
   DEST_INFO_DETAIL     varchar(3000) not null,
   DEST_LATITUDE        varchar(10),
   DEST_LONGITUDE       varchar(10),
   primary key (DEST_ID)
);

/*==============================================================*/
/* Table: JENIS_KELAMIN                                         */
/*==============================================================*/
create table JENIS_KELAMIN
(
   JENIS_KELAMIN_ID     int not null,
   JENIS_KELAMIN_KETERANGAN varchar(15) not null,
   primary key (JENIS_KELAMIN_ID)
);

/*==============================================================*/
/* Table: JENIS_WISATA                                          */
/*==============================================================*/
create table JENIS_WISATA
(
   JENIS_WISATA_ID      int not null,
   JENIS_WISATA_NAMA    varchar(25) not null,
   primary key (JENIS_WISATA_ID)
);

/*==============================================================*/
/* Table: KAMAR                                                 */
/*==============================================================*/
create table KAMAR
(
   KAMAR_ID             int not null,
   PROPERTI_ID          int,
   KAMAR_NAMA           varchar(20) not null,
   KAMAR_KETERSEDIAAN   int,
   KAMAR_GAMBAR_ALAMAT  varchar(500),
   KAMAR_FASILITAS      varchar(500),
   primary key (KAMAR_ID)
);

/*==============================================================*/
/* Table: NEGARA                                                */
/*==============================================================*/
create table NEGARA
(
   NEGARA_ID            int not null,
   NEGARA_NAMA          varchar(30) not null,
   primary key (NEGARA_ID)
);

/*==============================================================*/
/* Table: NOTIF_PROPERTI                                        */
/*==============================================================*/
create table NOTIF_PROPERTI
(
   NOTIF_PROP_ID        int not null,
   PROPERTI_ID          int,
   NOTIF_PROP_STATUS    int,
   primary key (NOTIF_PROP_ID)
);

/*==============================================================*/
/* Table: NOTIF_TURIS                                           */
/*==============================================================*/
create table NOTIF_TURIS
(
   NOTIF_TURIS_ID       int not null,
   TURIS_ID             int,
   NOTIF_TURIS_STATUS   int,
   primary key (NOTIF_TURIS_ID)
);

/*==============================================================*/
/* Table: OWNER                                                 */
/*==============================================================*/
create table OWNER
(
   OWNER_ID             int not null,
   OWNER_NAMA           varchar(30) not null,
   OWNER_ALAMAT         varchar(30) not null,
   OWNER_TGL_LAHIR      date not null,
   OWNER_PET            varchar(30),
   primary key (OWNER_ID)
);

/*==============================================================*/
/* Table: PEMESANAN                                             */
/*==============================================================*/
create table PEMESANAN
(
   PEMESANAN_ID         int not null,
   TURIS_ID             int,
   PROPERTI_ID          int,
   PEMESANAN_STATUS     int,
   primary key (PEMESANAN_ID)
);

/*==============================================================*/
/* Table: PROPERTI                                              */
/*==============================================================*/
create table PROPERTI
(
   PROPERTI_ID          int not null,
   OWNER_ID             int,
   NEGARA_ID            int,
   PROPERTI_NAMA        varchar(30) not null,
   PROPERTI_ALAMAT      varchar(50) not null,
   PROPERTI_KOTA        varchar(30) not null,
   PROPERTI_NO_TELPON   varchar(15) not null,
   PROPERTI_LATITUDE    varchar(10),
   PROPERTI_LONGITUDE   varchar(10),
   PROPERTI_EMAIL       varchar(40) not null,
   PROPERTI_PASSWORD    varchar(40) not null,
   PROPERTI_JARAK_BANDARA decimal,
   PROPERTI_JARAK_TERMINAL decimal,
   PROPERTI_JARAK_STASIUN decimal,
   PROPERTI_DESKRIPSI   varchar(3000),
   PROPERTI_KEBIJAKAN   varchar(3000),
   PROPERTI_FASILITAS   varchar(3000),
   PROPERTI_VERIFIED    int not null,
   primary key (PROPERTI_ID)
);

/*==============================================================*/
/* Table: REVIEW                                                */
/*==============================================================*/
create table REVIEW
(
   REVIEW_ID            int not null,
   OWNER_ID             int,
   TURIS_ID             int,
   REVIEW_TURIS         varchar(300),
   REVIEW_OWNER         varchar(300),
   primary key (REVIEW_ID)
);

/*==============================================================*/
/* Table: STATUS_PERNIKAHAN                                     */
/*==============================================================*/
create table STATUS_PERNIKAHAN
(
   STATUS_PERNIKAHAN_ID int not null,
   STATUS_PERNIKAHAN_KETERANGAN varchar(10) not null,
   primary key (STATUS_PERNIKAHAN_ID)
);

/*==============================================================*/
/* Table: TMPT_MENARIK                                          */
/*==============================================================*/
create table TMPT_MENARIK
(
   TMPT_MENARIK_ID      int not null,
   PROPERTI_ID          int,
   TMPT_MENARIK_DETAIL  varchar(40) not null,
   primary key (TMPT_MENARIK_ID)
);

/*==============================================================*/
/* Table: TURIS                                                 */
/*==============================================================*/
create table TURIS
(
   TURIS_ID             int not null,
   JENIS_KELAMIN_ID     int,
   STATUS_PERNIKAHAN_ID int,
   TURIS_NAMA           varchar(50) not null,
   TURIS_TGL_LAHIR      date not null,
   TURIS_NO_TELP        varchar(15) not null,
   TURIS_EMAIL          varchar(40) not null,
   TURIS_PASSWORD       varchar(40) not null,
   TURIS_FOTO           varchar(500) not null,
   TURIS_VERIFIED       int not null,
   primary key (TURIS_ID)
);

alter table DESTINASI_TEMPAT_WISATA add constraint FK_RELATIONSHIP_16 foreign key (DEST_ID)
      references INFO_DESTINASI (DEST_ID) on delete restrict on update restrict;

alter table DESTINASI_TEMPAT_WISATA add constraint FK_RELATIONSHIP_17 foreign key (JENIS_WISATA_ID)
      references JENIS_WISATA (JENIS_WISATA_ID) on delete restrict on update restrict;

alter table GBR_DESTINASI add constraint FK_RELATIONSHIP_9 foreign key (DEST_ID)
      references INFO_DESTINASI (DEST_ID) on delete restrict on update restrict;

alter table GBR_PROPERTI add constraint FK_RELATIONSHIP_4 foreign key (PROPERTI_ID)
      references PROPERTI (PROPERTI_ID) on delete restrict on update restrict;

alter table HUNTING_GROUND add constraint FK_RELATIONSHIP_12 foreign key (TURIS_ID)
      references TURIS (TURIS_ID) on delete restrict on update restrict;

alter table KAMAR add constraint FK_RELATIONSHIP_5 foreign key (PROPERTI_ID)
      references PROPERTI (PROPERTI_ID) on delete restrict on update restrict;

alter table NOTIF_PROPERTI add constraint FK_RELATIONSHIP_11 foreign key (PROPERTI_ID)
      references PROPERTI (PROPERTI_ID) on delete restrict on update restrict;

alter table NOTIF_TURIS add constraint FK_RELATIONSHIP_20 foreign key (TURIS_ID)
      references TURIS (TURIS_ID) on delete restrict on update restrict;

alter table PEMESANAN add constraint FK_RELATIONSHIP_22 foreign key (TURIS_ID)
      references TURIS (TURIS_ID) on delete restrict on update restrict;

alter table PEMESANAN add constraint FK_RELATIONSHIP_23 foreign key (PROPERTI_ID)
      references PROPERTI (PROPERTI_ID) on delete restrict on update restrict;

alter table PROPERTI add constraint FK_RELATIONSHIP_2 foreign key (OWNER_ID)
      references OWNER (OWNER_ID) on delete restrict on update restrict;

alter table PROPERTI add constraint FK_RELATIONSHIP_21 foreign key (NEGARA_ID)
      references NEGARA (NEGARA_ID) on delete restrict on update restrict;

alter table REVIEW add constraint FK_RELATIONSHIP_18 foreign key (TURIS_ID)
      references TURIS (TURIS_ID) on delete restrict on update restrict;

alter table REVIEW add constraint FK_RELATIONSHIP_19 foreign key (OWNER_ID)
      references OWNER (OWNER_ID) on delete restrict on update restrict;

alter table TMPT_MENARIK add constraint FK_RELATIONSHIP_7 foreign key (PROPERTI_ID)
      references PROPERTI (PROPERTI_ID) on delete restrict on update restrict;

alter table TURIS add constraint FK_RELATIONSHIP_24 foreign key (JENIS_KELAMIN_ID)
      references JENIS_KELAMIN (JENIS_KELAMIN_ID) on delete restrict on update restrict;

alter table TURIS add constraint FK_RELATIONSHIP_25 foreign key (STATUS_PERNIKAHAN_ID)
      references STATUS_PERNIKAHAN (STATUS_PERNIKAHAN_ID) on delete restrict on update restrict;

