create sequence hibernate_sequence start with 1 increment by 1;

create table passphrase
(
    passphrase_id bigint      not null,
    created       timestamp   not null,
    passkey       varchar(20) not null,
    primary key (passphrase_id)
);

create table word
(
    word_id       bigint       not null,
    word          varchar(255) not null,
    passphrase_id bigint       not null,
    primary key (word_id)
);

alter table passphrase
    add constraint UK_a3pb2f6tt93aer89b7ndn2e31 unique (passkey);

alter table word
    add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase;
create sequence hibernate_sequence start with 1 increment by 1
create table authenticated_user (user_id bigint not null, created timestamp not null, oauth_key varchar(255) not null, primary key (user_id))
create table passphrase (passphrase_id bigint not null, created timestamp not null, passkey varchar(20) not null, primary key (passphrase_id))
create table word (word_id bigint not null, word varchar(255) not null, passphrase_id bigint not null, primary key (word_id))
alter table authenticated_user add constraint UK_smnv9ssvph65qbj1e8jteiyf0 unique (oauth_key)
alter table passphrase add constraint UK_a3pb2f6tt93aer89b7ndn2e31 unique (passkey)
alter table word add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase
create sequence hibernate_sequence start with 1 increment by 1
create table authenticated_user (user_id bigint not null, created timestamp not null, oauth_key varchar(255) not null, primary key (user_id))
create table passphrase (passphrase_id bigint not null, created timestamp not null, passkey varchar(20) not null, user_id bigint not null, primary key (passphrase_id))
create table word (word_id bigint not null, word varchar(255) not null, passphrase_id bigint not null, primary key (word_id))
alter table authenticated_user add constraint UK_smnv9ssvph65qbj1e8jteiyf0 unique (oauth_key)
alter table passphrase add constraint UK_a3pb2f6tt93aer89b7ndn2e31 unique (passkey)
alter table passphrase add constraint FKe8hr9u5pt1rrudnamn4y211mt foreign key (user_id) references authenticated_user
alter table word add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase
