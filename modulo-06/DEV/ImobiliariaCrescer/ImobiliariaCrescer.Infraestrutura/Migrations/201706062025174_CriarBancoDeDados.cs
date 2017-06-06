namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriarBancoDeDados : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        CPF = c.Int(nullable: false),
                        Telefone = c.Int(nullable: false),
                        Endereco = c.String(),
                        DataDeNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoProduto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                        Pedido_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Produtos", t => t.IdProduto, cascadeDelete: true)
                .ForeignKey("dbo.Pedidos", t => t.Pedido_Id)
                .Index(t => t.IdProduto)
                .Index(t => t.Pedido_Id);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Pacote = c.String(),
                        Tipo = c.String(),
                        Quantidade = c.Int(nullable: false),
                        PrecoDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataEntrega = c.DateTime(nullable: false),
                        DataVencimento = c.DateTime(nullable: false),
                        IdCliente = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .Index(t => t.IdCliente);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        Senha = c.String(),
                        Gerente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PedidoProduto", "Pedido_Id", "dbo.Pedidos");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.PedidoProduto", "IdProduto", "dbo.Produtos");
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropIndex("dbo.PedidoProduto", new[] { "Pedido_Id" });
            DropIndex("dbo.PedidoProduto", new[] { "IdProduto" });
            DropTable("dbo.Usuarios");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Produtos");
            DropTable("dbo.PedidoProduto");
            DropTable("dbo.Clientes");
        }
    }
}
