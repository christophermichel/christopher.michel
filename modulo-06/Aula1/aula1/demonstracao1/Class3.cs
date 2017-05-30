using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demonstracao01
{
    class Classe3
    {
        static void Main(string[] args)
        {
            var dados = new double[1];
            int i = 0;

            while (true)
            {
                Console.WriteLine("digite um numero");
                var valor = Console.ReadLine();

                if (valor == "exit")
                {
                    break;
                }

                var novoDado = new double[dados.Length + 1];

                for (i = 0; i < novoDado.Length; i++)
                {
                    novoDado[i] = dados[1];
                    novoDado[i] = double.Parse(valor);
                }

                dados = novoDado;
            }
            foreach (var dado in dados)
            {

            }
        }
    }
}