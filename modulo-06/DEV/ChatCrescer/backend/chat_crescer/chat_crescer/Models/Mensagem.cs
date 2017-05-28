using System;

namespace chat_crescer.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public Usuario usuario { get; set; }
        public string Texto { get; set; }
        public DateTime HoraDeEnvio { get; set; }
    }
}