using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double PrecoPorHoras = Math.Round(salarioBase / horasCategoria, 2);
            HorasCalculadas CustoHorasExtras = new HorasCalculadas(horasExtras, PrecoPorHoras);
            HorasCalculadas TotalHorasDescontadas = new HorasCalculadas(horasDescontadas, PrecoPorHoras);
            double TotalDeProventos = Math.Round(salarioBase + CustoHorasExtras.Calcular() - TotalHorasDescontadas.Calcular(), 2);
            Desconto INSS = new Desconto(INSS_aliquota(TotalDeProventos), TotalDeProventos);
            Desconto IRRF = new Desconto(IRRF_aliquota(TotalDeProventos - INSS.CalcularDesconto()), TotalDeProventos - INSS.CalcularDesconto());
            double TotalDescontos = INSS.CalcularDesconto() + IRRF.CalcularDesconto();
            double SalarioLiquido = Math.Round(TotalDeProventos - TotalDescontos, 2);
            Desconto FGTS = new Desconto((11 / 100), TotalDeProventos);
        
            Demonstrativo modelo = new Demonstrativo (salarioBase, horasCategoria, CustoHorasExtras, TotalHorasDescontadas, TotalDeProventos, INSS, IRRF, TotalDescontos, SalarioLiquido, FGTS);

            modelo.demonstrativoNoConsole();
       
            return modelo;
        }

        public double INSS_aliquota(double totalProventos)
        {
            if (totalProventos <= 1000)
            {
                return (8/100);
            }
            else if (totalProventos <= 1500)
            {
                return (9/100);
            }
            else
            {
                return (10/100);
            }
        }

        public double IRRF_aliquota(double proventosComINSSDeduzido)
        {
            if (proventosComINSSDeduzido <= 1710.78)
            {
                return 0;
            }
            else if (proventosComINSSDeduzido <= 2563.91)
            {
                return (7.5/100);
            }
            else if (proventosComINSSDeduzido <= 3418.59)
            {
                return (15/100);
            }
            else if (proventosComINSSDeduzido <= 4271.59)
            {
                return (22.5/100);
            }
            else
            {
                return (27.5/100);
            }
        }
    }
}
