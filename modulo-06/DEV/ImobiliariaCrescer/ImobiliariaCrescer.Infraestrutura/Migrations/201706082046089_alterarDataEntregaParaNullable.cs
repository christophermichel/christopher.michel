namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alterarDataEntregaParaNullable : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Clientes", "CPF", c => c.String());
            AlterColumn("dbo.Pedidos", "DataEntrega", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Pedidos", "DataEntrega", c => c.DateTime(nullable: false));
            AlterColumn("dbo.Clientes", "CPF", c => c.Int(nullable: false));
        }
    }
}
