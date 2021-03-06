package br.com.casadocodigo.loja.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.casadocodigo.loja")
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
      configurer.enable();
   }

   @Bean
   public InternalResourceViewResolver internalResourceViewResolver(){
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   @Bean(name = "messageSource")
   public MessageSource messageSource(){
	   ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
	   bundle.setBasename("/WEB-INF/messages");
	   bundle.setDefaultEncoding("UTF-8");
	   bundle.setCacheSeconds(1);	//	Indica que o arquivo de mensagens deve ser carregado a cada intervalo de tempo (1 segundo)
	   return bundle;
   }
   
   @Bean(name = "mvcConversionService")
   public FormattingConversionService mvcConversionService() {
	   DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
	   DateFormatterRegistrar registrar = new DateFormatterRegistrar();
	   registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
	   registrar.registerFormatters(conversionService);
	   return conversionService;
   }
   
   @Bean(name = "multipartResolver")
   public MultipartResolver multipartResolver(){
	   return new StandardServletMultipartResolver();
   }
   
}
