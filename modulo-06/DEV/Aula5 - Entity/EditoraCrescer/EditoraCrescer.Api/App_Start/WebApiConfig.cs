﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace EditoraCrescer.Api
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Serviços e configuração da API da Web

            // Rotas da API da Web
            config.EnableCors(new System.Web.Http.Cors.EnableCorsAttribute("*", "*", "*"));
            config.MapHttpAttributeRoutes();

            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{id}",
                defaults: new { id = RouteParameter.Optional }
            );
        }
    }
}
