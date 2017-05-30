using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar(out List<string> mensagensErro)
        {
            mensagensErro = new List<string>();
            foreach (var item in Itens)
            {
                if (item.Quantidade < 1)
                {
                    mensagensErro.Add("Quantidade inválida, favor alterar");
                }
            }
            return mensagensErro.Count == 0;
        }
    }
}
