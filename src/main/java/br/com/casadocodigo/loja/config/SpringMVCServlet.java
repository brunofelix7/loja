package br.com.casadocodigo.loja.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe de ativação do Spring MVC
 * Essa classe contém um DispatcherServlet responsável por tratar todas as requisições para o Spring MVC
 * O objetivo de herdar dessa classe é justamente não ter de ficar fazendo o registro do DispatcherServlet na mão
 */
public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer{
   
   @Override
   protected Class<?>[] getRootConfigClasses(){
      return null;
   }

   @Override
   protected Class<?>[] getServletConfigClasses(){
      return new Class[]{ AppWebConfiguration.class, JPAConfiguration.class };
   }

   @Override
   protected String[] getServletMappings(){
      return new String[] { "/" };
   }

}
