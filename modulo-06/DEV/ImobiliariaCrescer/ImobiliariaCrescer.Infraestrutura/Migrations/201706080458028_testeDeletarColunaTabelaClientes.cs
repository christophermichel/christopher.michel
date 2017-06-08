namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class testeDeletarColunaTabelaClientes : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Clientes", "Telefone");
            DropColumn("dbo.Clientes", "Endereco");
            DropColumn("dbo.Clientes", "Genero");
            DropColumn("dbo.Clientes", "DataDeNascimento");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Clientes", "DataDeNascimento", c => c.DateTime(nullable: false));
            AddColumn("dbo.Clientes", "Genero", c => c.String());
            AddColumn("dbo.Clientes", "Endereco", c => c.String());
            AddColumn("dbo.Clientes", "Telefone", c => c.Int(nullable: false));
        }
    }
}
