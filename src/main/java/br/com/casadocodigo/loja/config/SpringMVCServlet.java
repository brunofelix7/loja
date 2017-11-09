package br.com.casadocodigo.loja.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe de ativação do Spring MVC
 * Essa classe contém um DispatcherServlet responsável por tratar todas as requisições para o Spring MVC
 * O objetivo de herdar dessa classe é justamente não ter de ficar fazendo o registro do DispatcherServlet na mão
 */
public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer{
   
   @Override
   protected Class<?>[] getRootConfigClasses(){
      return new Class[]{ AppWebConfiguration.class, JPAConfiguration.class, AmazonConfiguration.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses(){
      return new Class[]{ AppWebConfiguration.class, JPAConfiguration.class, AmazonConfiguration.class };
   }

   @Override
   protected String[] getServletMappings(){
      return new String[] { "/" };
   }

   @Override
	protected Filter[] getServletFilters() {
	   CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
      encodingFilter.setEncoding("UTF-8");
      return new Filter[] {encodingFilter};
	}
   
   @Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
   
}
