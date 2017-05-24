using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demonstracao1
{
    public class CalculoIMC
    {
        public double Altura { get; set; }
        public double Peso { get; set; }
        public CalculoIMC(double altura, double peso)
        {
            Altura = altura;
            Peso = peso;
        }
        
        public double CalcularIMC()
        {
            return Peso*100 / (Math.Pow(Altura, 2));
        }
    }
}
