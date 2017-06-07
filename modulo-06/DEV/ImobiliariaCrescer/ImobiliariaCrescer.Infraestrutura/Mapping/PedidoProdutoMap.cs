using ImobiliariaCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mapping
{
    public class PedidoProdutoMap : EntityTypeConfiguration<PedidoProduto>
    {
        public PedidoProdutoMap()
        {
            ToTable("PedidoProduto");
            Property(x => x.Id).HasDatabaseGeneratedOption(System.ComponentModel.DataAnnotations.Schema.DatabaseGeneratedOption.Identity);
            HasRequired(x => x.Produto)
            .WithMany()
            .Map(x => x.MapKey("IdProduto"));
        }
    }
}
