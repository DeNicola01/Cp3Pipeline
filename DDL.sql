Create Table TB_VOZ(cd_voz number(10) primary key,
                    frase varchar2(100) not null);

Create Table TB_EMPRESA(cd_empresa number(10) primary key,
                        nm_empresa varchar2(50) not null,
                        ds_cnpj char(14),
                        ds_empresa varchar2(100),
                        dt_cadastro date);
                        
select * from TB_VOZ;
select * from TB_EMPRESA;