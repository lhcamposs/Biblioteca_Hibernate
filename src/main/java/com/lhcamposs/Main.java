package com.lhcamposs;

import com.lhcamposs.controller.AutorController;
import com.lhcamposs.controller.EditoraController;
import com.lhcamposs.controller.LivroController;
import com.lhcamposs.util.HibernateUtil;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {
    public static void main(String[] args) throws Exception {
        HibernateUtil.getSessionFactory(); // Inicializa Hibernate

        Server server = new Server(8080);

        // Configuração do Jersey
        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter("jersey.config.server.provider.classnames",
                LivroController.class.getCanonicalName() + "," +
                        AutorController.class.getCanonicalName() + "," +
                        EditoraController.class.getCanonicalName());

        // Configuração do contexto
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(servletHolder, "/*");

        // Define o handler no servidor
        server.setHandler(context);

        server.start();
        System.out.println("Servidor rodando em http://localhost:8080");
        server.join();
    }
}
