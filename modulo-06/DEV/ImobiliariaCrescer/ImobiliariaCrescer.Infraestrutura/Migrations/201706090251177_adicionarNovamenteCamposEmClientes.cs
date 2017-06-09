namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarNovamenteCamposEmClientes : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Clientes", "Endereco", c => c.String());
            AddColumn("dbo.Clientes", "Genero", c => c.String());
            AddColumn("dbo.Clientes", "DataDeNascimento", c => c.DateTime(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Clientes", "DataDeNascimento");
            DropColumn("dbo.Clientes", "Genero");
            DropColumn("dbo.Clientes", "Endereco");
        }
    }
}
