drop database trabalhodb;
create database if not exists trabalhodb;
use trabalhodb;
create table IA(
	Ia_ID int not null primary key,
    Nome_IA char(255) not null,
    DataCriacao date not null,
	Versao varchar(255) not null
);

create table Simulacao(
	Simulacao_ID int not null primary key,
    Nome_Simulacao char(255) not null,
    Versao int not null,
    Fk_IA_ID int not null,
    foreign key(fk_IA_ID) references IA(Ia_iD)
    );
    
    
     create table BluePill(
		BluePill_ID int not null primary key,
        Nome_BluePill char(255) ,
        DataNascimento date,
        Email varchar(255) ,
        Telefone varchar(255) ,
        Idade int,
        Genero varchar(20),
        Fk_Simulacao_ID int not null,
        foreign key (Fk_simulacao_ID) references Simulacao(Simulacao_ID)
     );
    
    
     create table Agente(
		Agente_ID int not null primary key,
        Nome varchar(255) not null,
        versao varchar(255),
        fabriecante varchar(255),
        Fk_Simulacao_Id int not null ,
        Foreign key ( Fk_Simulacao_Id) references Simulacao( Simulacao_Id)
     );
	
     create table RedPill(
		RedPill_ID int not null primary key,
        Nome_RedPill varchar(255),
        DataNascimento date,
        Email varchar(255) ,
        Telefone varchar(255) ,
        Idade int,
        Genero varchar(20),
        Fk_Simulacao_ID int not null,
        foreign key (Fk_simulacao_ID) references Simulacao(Simulacao_Id)
     );
     
     
     create table Combate (
		Fk_Agente_ID int not null,
        Fk_RedPill_ID int not null,
        foreign key (Fk_Agente_ID) references Agente(Agente_Id),
		foreign key (Fk_RedPill_ID) references Redpill(RedPill_ID)
     );
     

     
     create table Realidade(
     Realidade_ID int not null primary key,
     Nome_Realidade varchar(255) not null,
     NHabitantes bigint not null
     );
     
     
     create table Resistencia (
		Resistencia_ID int not null primary key,
        Nome_Resistencia varchar(255) not null,
        Localizacao varchar(255),
        NomeLider varchar(255),
        Fk_Realidade_ID int not null,
        Foreign key (Fk_Realidade_ID) references Realidade( Realidade_ID)
     );
     
     -- INSERTS--
	insert into IA (Ia_ID, Nome_IA, DataCriacao, Versao) values( 1,"Matrix","1998-01-02","1.1");
	insert into IA (Ia_ID, Nome_IA, DataCriacao, Versao) values( 2,"GPT","2010-01-20","1.2");
	insert into IA (Ia_ID, Nome_IA, DataCriacao, Versao) values( 3,"DAll_E","2000-01-09","2.5");
    insert into IA (Ia_ID, Nome_IA, DataCriacao, Versao) values( 4,"GCP","2015-12-09","1.8.9");
	insert into IA (Ia_ID, Nome_IA, DataCriacao, Versao) values( 5,"TXM","2016-09-12","1.5.2");
    
    insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(1,"Matrix",1,1122);
	insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(2,"Desert",2,3344);
	insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(3,"DeskPark",3,5566);
    insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(4,"Simulaçao04",1,7788);
    insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(5,"Simulação05",2,9900);
	insert into Simulacao (Simulacao_ID,Nome_Simulacao, Fk_IA_ID, Versao) values(6,"Simulação06",1,10000);
    
	insert into BluePill (BluePill_ID,Nome_BluePill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(1,"Matheus","2002-06-09","Matheus@gmail.com","199927894",20,"Masculino",2);
	insert into BluePill (BluePill_ID,Nome_BluePill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(2,"Joao","2022-06-09","Joao@gmail.com","199943123",01,"Masculino",3);
    insert into BluePill (BluePill_ID,Nome_BluePill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(3,"Thais","2002-09-14","thais@gmail.com","199925468",20,"Femenino",1);
	insert into BluePill (BluePill_ID,Nome_BluePill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(4,"Ana","1990-09-14","Ana@gmail.com","199987468",32,"Femenino",2);
    insert into BluePill (BluePill_ID,Nome_BluePill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(5,"Bruno","2000-10-21","Bruno@gmail.com","199123468",23,"Masculino",3);
    
         -- ALTER TABLE --
     
     	ALTER TABLE Agente
		CHANGE COLUMN nome Nome_Agente varchar(30);
    
	insert into Agente (Agente_ID, Nome_Agente,  Fk_Simulacao_ID, Versao) values(1,"Agente01",1,12);
	insert into Agente (Agente_ID, Nome_Agente,  Fk_Simulacao_ID, Versao) values(2,"Agente02",2,34);
	insert into Agente (Agente_ID, Nome_Agente,  Fk_Simulacao_ID, Versao) values(3,"Agente03",3,56);
    insert into Agente (Agente_ID, Nome_Agente,  Fk_Simulacao_ID, Versao) values(4,"Agente04",4,23);
    
    
    
	insert into RedPill (RedPill_ID,Nome_RedPill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(1,"Jorge","2002-06-09","jorge@gmail.com","199965894",20,"Masculino",2);
	insert into RedPill (RedPill_ID,Nome_RedPill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(2,"Thiago","2022-06-09","thiago@gmail.com","139453123",01,"Masculino",3);
    insert into RedPill (RedPill_ID,Nome_RedPill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(3,"Ana","2002-09-14","douglas@gmail.com","159926768",20,"Femenino",1);
	insert into RedPill (RedPill_ID,Nome_RedPill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(4,"Bruno","2015-09-14","Bruno@gmail.com","159923468",17,"Masculino",1);
    insert into RedPill (RedPill_ID,Nome_RedPill, DataNascimento, Email, Telefone, Idade, Genero,Fk_Simulacao_ID) values(5,"Igor","2000-12-01","Igor@gmail.com","159934568",22,"Masculino",2);
    
    
	insert into Combate(Fk_Agente_ID,Fk_RedPill_ID) values(1,2);
	insert into Combate(Fk_Agente_ID,Fk_RedPill_ID) values(3,2);
	insert into Combate(Fk_Agente_ID,Fk_RedPill_ID) values(2,2);
    
    
	insert into Realidade(Realidade_ID,Nome_Realidade, NHabitantes ) values(1,"Terra",7000000000);
	insert into Realidade(Realidade_ID,Nome_Realidade, NHabitantes ) values(2,"Terra76",5000000000);
	insert into Realidade(Realidade_ID,Nome_Realidade, NHabitantes ) values(3,"Terra146",2003000000);
    insert into Realidade(Realidade_ID,Nome_Realidade, NHabitantes ) values(4,"Terra66",480000000);
    
     
     insert into Resistencia (Resistencia_ID, Nome_Resistencia, Localizacao, NomeLider, Fk_Realidade_ID) values(1, "Resistencia", "Rua Denadai","Davi", 2);
     insert into Resistencia (Resistencia_ID, Nome_Resistencia, Localizacao, NomeLider, Fk_Realidade_ID) values(2, "Reds", "Rua Amelia","Leonardo", 1);
	 insert into Resistencia (Resistencia_ID, Nome_Resistencia, Localizacao, NomeLider, Fk_Realidade_ID) values(3, "AntiMatrix", "Rua LugarNenhum","Stan", 3);
	 insert into Resistencia (Resistencia_ID, Nome_Resistencia, Localizacao, NomeLider, Fk_Realidade_ID) values(4, "Trixma", "Rua Osvaldo","Morfeus", 4);
     

        
        ALTER TABLE  Agente
        DROP COLUMN  fabriecante;
        
        
        -- UPDATE --
        update Simulacao set Nome_Simulacao="Matrix002"
        where Simulacao_ID=2;
        
        select Nome_simulacao from Simulacao;
        
        -- DELETE -- 
		DELETE FROM bluepill 
		WHERE BluePill_ID = 3; 
        
        select * from bluepill;
        
	