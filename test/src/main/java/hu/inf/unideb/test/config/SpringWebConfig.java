/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.inf.unideb.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "hu.inf.unideb.test.validator" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
                registry.addResourceHandler("/**").addResourceLocations("/**");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

  @Bean(name = "messageSource")
  public ResourceBundleMessageSource getMessageSource() {
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasename("config/validation");
      messageSource.setDefaultEncoding("UTF-8");
      messageSource.setUseCodeAsDefaultMessage(true);
      return messageSource;
  }
      @Bean(name = "dataSource")

 public DriverManagerDataSource dataSource() {

     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

     driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
     driverManagerDataSource.setUrl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7268228");
     driverManagerDataSource.setUsername("sql7268228");
     driverManagerDataSource.setPassword("pqWuFgztmP");
     return driverManagerDataSource;

 }

}