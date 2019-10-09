﻿using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using ServerSite.Ids4;

namespace ServerSite
{
    public class Startup
    {
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddLogging(_ => _.AddConsole());

            services.AddRouting();

            services.AddControllersWithViews();

            services.AddIds4();
        }

        public void Configure(IApplicationBuilder app)
        {
            app.UseDeveloperExceptionPage();

            app.UseIds4();

            app.UseStaticFiles();

            app.UseRouting();

            app.UseEndpoints(_ => _.MapDefaultControllerRoute());
        }
    }
}