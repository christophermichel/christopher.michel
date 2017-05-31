﻿using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}