using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class Demonstrativo
    {
        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }

        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }

        public void demonstrativoNoConsole()
        {
            Console.WriteLine("DEMONSTRATIVO DE FOLHA DE PAGAMENTO (CONTRA-CHEQUE)");
            Console.WriteLine(string.Concat("Salario Mensalista (", this.HrsConvencao,"): ", this.SalarioBase));
            Console.WriteLine(string.Concat("Horas Extras (", this.HorasExtras.QtdHoras , "): " , this.HorasExtras.Calcular()));
            Console.WriteLine(string.Concat("Horas Descontadas (" , this.HorasDescontadas.QtdHoras , "): " , this.HorasDescontadas.Calcular()));
            Console.WriteLine(string.Concat("Total de Proventos: " , this.TotalProventos));
            Console.WriteLine(string.Concat("INSS(" , this.Inss.Aliquota , "): " , this.Inss.CalcularDesconto()));
            Console.WriteLine(string.Concat("IRRF(" , this.Irrf.Aliquota , "): " , this.Irrf.CalcularDesconto()));
            Console.WriteLine(string.Concat("Total de Descontos: " , this.TotalDescontos));
            Console.WriteLine(string.Concat("Total de Líquido: " , this.TotalLiquido));
            Console.WriteLine(string.Concat("FGTS(" , this.Fgts.Aliquota , "): " + this.Fgts.CalcularDesconto()));
            Console.ReadKey();
        }
    }
}
