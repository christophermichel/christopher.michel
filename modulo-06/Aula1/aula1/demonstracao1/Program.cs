using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demonstracao1
{
    class public Program
    {
        var entrada = new int[] { };
        public int i = 0;
        while (true)
            {
            i = i + 1;
            Console.WriteLine("Digite um valor: ");
            var entrada = Console.ReadLine(elemento);
            var saida = new int[i] { };
            saida[i] = elemento;

            if (entrada == "exit")
            {
                 return;
            }
                 Console.WriteLine("O array final é: ");         
            }


    /*static void Main(string[] args)
    {

        var entrada = new int[] { };
        public int i = 0;
    public Boolean condicao = true;

        while (true)
            {
            i = i + 1;
            Console.WriteLine("Digite um valor: ");
            var entrada = Console.ReadLine(elemento);
            var saida = new int[i] { };
            saida[i] = elemento;

            if (entrada == "exit")
            {
                return;
            }
             Console.WriteLine("O array final é: ");

            }
}
*/
    /*Console.WriteLine("Informe seu peso");
    var entradaPeso = Console.ReadLine();

    Console.WriteLine("Informe sua altura");
    var entradaAltura = Console.ReadLine();

    var peso = 0D;
    if (!double.TryParse(entradaPeso, out peso))
        Console.WriteLine("Entrada inválida");
    var altura = double.Parse(entradaAltura);

    var calculoIMC = new CalculoIMC(altura, peso);
    var imc = calculoIMC.CalcularIMC();

    Pessoa pessoa = new Pessoa();
    pessoa.ID = 1;
    pessoa.Nascimento = new DateTime(1982, 10, 29);
    pessoa.Nome = $"Christopher Michel {pessoa.Nome}";

    Console.Write(imc);*/

    Console.ReadKey();
        }

    //static Pessoa CriarPessoa()
    //return new Endereco();

}
}
