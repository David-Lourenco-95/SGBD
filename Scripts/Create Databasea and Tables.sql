USE master

IF EXISTS(SELECT * FROM sys.databases WHERE name = 'TP2018')

BEGIN
   DROP DATABASE TP2018
END

CREATE DATABASE TP2018
GO

USE TP2018

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Regiao]'))
begin
create table Regiao(
Regiao_ID int identity(1,1) not null
	check(Regiao_ID>=0),
Nome nvarchar(80) not null,
constraint PK_Regiao_ID primary key(Regiao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Centro]'))
begin
create table Centro(
Centro_ID int identity(1,1) not null
	check(Centro_ID>=0),
Nome nvarchar(80) not null,
Regiao_ID int not null
	check(Regiao_ID>=0),
constraint PK_Centro_ID primary key(Centro_ID),
constraint FK_Regiao_ID foreign key (Regiao_ID) references Regiao (Regiao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Especialidade]'))
begin
create table Especialidade(
Especialidade_ID int identity(1,1) not null
	check(Especialidade_ID>=0),
Nome nvarchar(80) not null,
constraint PK_Especialidade_ID primary key(Especialidade_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Funcionario]'))
begin
create table Funcionario(
Funcionario_ID int identity(1,1) not null
	check(Funcionario_ID>=0),
Nome nvarchar(80) not null,
NIF nvarchar(80) not null,
Morada nvarchar(80) not null,
Contacto nvarchar(80) not null,
Data_Nascimento nvarchar(80) not null,
Tipo_Funcionario nvarchar(80) not null,
Email nvarchar(80) not null,
Estudos nvarchar(80) not null,
Especialidade_ID int,
constraint PK_Funcionario_ID primary key (Funcionario_ID),
constraint FK_Especialidade_ID foreign key (Especialidade_ID) references Especialidade (Especialidade_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Intervencao]'))
begin
create table Intervencao(
Intervencao_ID int identity(1,1) not null
	check(Intervencao_ID>=0),
Tipo nvarchar(50) not null,
Sintomas nvarchar(2000),
Diagnostico nvarchar(2000),
Especialidade_ID int,
Descricao nvarchar(200) not null,
Estado nvarchar(100) not null,
ano int,
mes int,
dia int,
hora int,
minuto int,
constraint PK_Intervencao_ID primary key (Intervencao_ID),
constraint FK_Especialidade_ID2 foreign key (Especialidade_ID) references Especialidade(Especialidade_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Horario_Funcionario]'))
begin
create table Horario_Funcionario(
Funcionario_ID int not null
	check(Funcionario_ID>=0),
ano int,
mes int,
dia int,
hora int,
minuto int,
Intervencao_ID int not null,
constraint PK_Intervencao_Funcionario_ID primary key(Intervencao_ID,Funcionario_ID),
constraint FK_Funcionario_ID2 foreign key (Funcionario_ID) references Funcionario (Funcionario_ID),
constraint FK_Intervencao_ID foreign key (Intervencao_ID) references Intervencao (Intervencao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Equipa]'))
begin
create table Equipa(
Equipa_ID int identity(1,1) not null
	check(Equipa_ID>=0),
Centro_ID int not null
	check(Centro_ID>=0),
constraint PK_Equipa_ID primary key(Equipa_ID),
constraint FK_Centro_ID6 foreign key (Centro_ID) references Centro(Centro_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Atribuicao_Equipa]'))
begin
create table Atribuicao_Equipa(
Equipa_ID int not null
	check(Equipa_ID>=0),
Funcionario_ID int not null
	check(Funcionario_ID>=0),
constraint PK_Equipa_Func_ID primary key(Equipa_ID,Funcionario_ID),
constraint FK_Equipa_ID foreign key (Equipa_ID) references Equipa (Equipa_ID),
constraint FK_Funcionario_ID3 foreign key (Funcionario_ID) references Funcionario(Funcionario_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Utente]'))
begin
create table Utente(
Utente_ID int identity(1,1) not null
	check(Utente_ID>=0),
Nome nvarchar(80) not null,
Morada nvarchar(80) not null,
Idade nvarchar(3) not null,
Contacto nvarchar(15) not null,
Data_Nasc nvarchar(10) not null,
NIF nvarchar(15) not null,
email nvarchar(50),
Centro_ID int not null
	check(Centro_ID>=0),
constraint PK_Utente_ID primary key (Utente_ID),
constraint FK_Centro_ID2 foreign key (Centro_ID) references Centro(Centro_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Medicamento]'))
begin
create table Medicamento(
Medicamento_ID int identity(1,1) not null
	check(Medicamento_ID>=0),
Nome nvarchar(50) not null,
Validade nvarchar(15) not null, --data type
Preço decimal(7,2) not null,
	check(Preço>=0.0),
Stock int not null,
Fornecedor nvarchar(50) not null,
constraint PK_Medicamento_ID primary key (Medicamento_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Receita]'))
begin
create table Receita(
Receita_ID int identity(1,1) not null
	check(Receita_ID>=0),
Intervencao_ID int not null
	check(Intervencao_ID>=0),
constraint PK_Receita_ID primary key (Receita_ID),
constraint FK_Intervencao_ID3 foreign key (Intervencao_ID) references Intervencao(Intervencao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Atribuicao_Receita]'))
begin
create table Atribuicao_Receita(
Receita_ID int not null
	check(Receita_ID>=0),
Medicamento_ID int not null
	check(Medicamento_ID>=0),
constraint PK_Receita_ID2 primary key (Receita_ID,Medicamento_ID),
constraint FK_Receita_ID foreign key (Receita_ID) references Receita(Receita_ID),
constraint FK_Medicamento_ID foreign key (Medicamento_ID) references Medicamento(Medicamento_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Sala]'))
begin
create table Sala(
Sala_ID int identity(1,1) not null
	check(Sala_ID>=0),
tipo nvarchar(30) not null,
Centro_ID int not null
	check(Centro_ID>=0),
constraint PK_Sala_ID primary key (Sala_ID),
constraint FK_Centro_ID3 foreign key (Centro_ID) references Centro(Centro_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Equipamento]'))
begin
create table Equipamento(
Equipamento_ID int identity(1,1) not null
	check(Equipamento_ID>=0),
Nome nvarchar(80) not null,
Validade nvarchar(15) not null,--data type
Nr_Utilizacoes int not null,
Sala_ID int not null
	check(Sala_ID>=0),
constraint PK_Equipamento_ID primary key (Equipamento_ID),
constraint FK_Sala_ID foreign key (Sala_ID) references Sala(Sala_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Horario_Sala]'))
begin
create table Horario_Sala(
Sala_ID int not null
	check(Sala_ID>=0),
ano int,
mes int,
dia int,
hora int,
minuto int,
Intervencao_ID int not null,
constraint PK_Intervencao_Sala_ID primary key (intervencao_ID,Sala_ID),
constraint FK_Sala_ID2 foreign key (Sala_ID) references Sala (Sala_ID),
constraint FK_Intervencao_ID4 foreign key (Intervencao_ID) references Intervencao (Intervencao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Maca]'))
begin
create table Maca(
Maca_ID int identity(1,1) not null
	check(Maca_ID>=0),
Centro_ID int not null
	check(Centro_ID>=0),
Utente_ID int not null
	check(Utente_ID>=0),
constraint PK_Utente_ID2 primary key (Maca_ID),
constraint FK_Centro_ID4 foreign key (Centro_ID) references Centro(Centro_ID),
constraint FK_Utente_ID2 foreign key (Utente_ID) references Utente (Utente_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Quarto]'))
begin
create table Quarto(
Quarto_ID int identity(1,1) not null
	check(Quarto_ID>=0),
Centro_ID int not null
	check(Centro_ID>=0),
constraint PK_Quarto_ID primary key (Quarto_ID),
constraint FK_Centro_ID5 foreign key (Centro_ID) references Centro(Centro_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Cama]'))
begin
create table Cama(
Cama_ID int identity(1,1) not null
	check(Cama_ID>=0),
Utente_ID int,
Quarto_ID int not null
	check(Quarto_ID>=0),
estado nvarchar(80),
constraint PK_Cama_ID primary key (Cama_ID),
constraint FK_Utente_ID3 foreign key (Utente_ID) references Utente(Utente_ID),
constraint FK_Quarto_ID foreign key (Quarto_ID) references Quarto(Quarto_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Internamento]'))
begin
create table Internamento(
Internamento_ID int identity(1,1) not null
	check(Internamento_ID>=0),
Utente_ID int not null
	check(Utente_ID>=0),
Cama_ID int not null
	check(Cama_ID>=0),
Intervencao_ID int not null
	check(Intervencao_ID>=0),
ano int,
mes int,
dia int,
hora int,
minuto int,
constraint PK_Internamento_ID primary key (Internamento_ID),
constraint FK_Utente_ID4 foreign key (Utente_ID) references Utente(Utente_ID),
constraint FK_Cama_ID foreign key (Cama_ID) references Cama(Cama_ID),
constraint FK_Intervencao_ID5 foreign key (Intervencao_ID) references Intervencao(Intervencao_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Intervencao_E_Internamento]'))
begin
create table Intervencao_E_Internamento(
IEI_ID int identity(1,1) not null
	check (IEI_ID>=0),
Intervencao_ID int,
Internamento_ID int,
constraint PK_IEI_ID primary key (IEI_ID),
constraint FK_Intervencao_ID6 foreign key (Intervencao_ID) references Intervencao (Intervencao_ID),
constraint FK_Internamento_ID foreign key (Internamento_ID) references Internamento (Internamento_ID),
);
end

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Registo_Clinico]'))
begin
create table Registo_Clinico(
Utente_ID int not null
	check(Utente_ID>=0),
ano int,
mes int,
dia int,
hora int,
minuto int,
Intervencao_Internamento_ID int not null
	check(Intervencao_Internamento_ID>=0),
constraint PK_registo_Utente_ID primary key (Intervencao_Internamento_ID,Utente_ID),
constraint FK_Utente_ID foreign key (Utente_ID) references Utente (Utente_ID),
constraint FK_Intervencao_Internamento_ID foreign key (Intervencao_Internamento_ID) references Intervencao_E_Internamento (IEI_ID),
);
end

alter table Intervencao
add Sala_ID int null
alter table Intervencao
add Equipa_ID int null
alter table Intervencao
add Utente_ID int null
alter table Intervencao
add constraint FK_Sala_ID3 foreign key (Sala_ID) references Sala(Sala_ID)
alter table Intervencao
add constraint FK_Equipa_ID2 foreign key (Equipa_ID) references Equipa(Equipa_ID)
alter table Intervencao
add constraint FK_Utente_ID5 foreign key (Utente_ID) references Utente(Utente_ID)

IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[Atribuicao_Intervencao]'))
begin
create table Atribuicao_Intervencao(
Intervencao_Atual_ID int not null
	check(Intervencao_Atual_ID>=0),
Intervencao_Proveniente_ID int,
constraint Intervencao_Atual_ID foreign key (Intervencao_Atual_ID) references Intervencao(Intervencao_ID),
constraint Intervencao_Proveniente_ID foreign key (Intervencao_Proveniente_ID) references Intervencao(Intervencao_ID),
constraint Intervencao_Atual_ID2 primary key (Intervencao_Atual_ID),
);
end
