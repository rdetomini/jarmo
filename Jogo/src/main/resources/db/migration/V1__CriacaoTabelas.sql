CREATE TABLE usuarios (
	id bigint not null auto_increment primary key,
	nome varchar(250) not null,
	email varchar(250) not null,
	senha varchar (250) not null,
	salt varchar (250) not null
 ) ENGINE=InnoDB;
 
 CREATE TABLE configuracoes_jogadas (
	id bigint not null auto_increment primary key,
	palavra varchar(5) not null,
	data_cadastro datetime not null
 ) ENGINE=InnoDB;
 
 CREATE TABLE jogadas (
	id bigint not null auto_increment primary key,
	palavra varchar(5) not null,
	data_tentativa datetime not null,
	acertou TINYINT(1) not null,
	usuario_id bigint not null,
	configuracao_jogada_id bigint not null,
    CONSTRAINT fk_jogadas_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_jogadas_configuracao_jogada FOREIGN KEY (configuracao_jogada_id) REFERENCES configuracoes_jogadas(id)
 ) ENGINE=InnoDB;