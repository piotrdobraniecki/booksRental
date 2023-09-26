package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.Converter.BookConverter;
import pl.coderslab.Converter.OpinionConverter;
import pl.coderslab.Converter.UserConverter;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(getBookConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getOpinionConverter());

    }

    @Bean
    public BookConverter getBookConverter () {
        return new BookConverter();
    }
    @Bean
    public UserConverter getUserConverter () {
        return new UserConverter();
    }
    @Bean
    public OpinionConverter getOpinionConverter () { return new OpinionConverter();}

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("bookstorePersistenceUnit");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }
    @Bean

    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver =

                new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;

    }

    @Override

    public void configureDefaultServletHandling(

            DefaultServletHandlerConfigurer configurer) {

        configurer.enable();

    }

    @Bean(name = "localeResolver")

    public LocaleContextResolver getLocaleContextResolver() {

        SessionLocaleResolver localeResolver = new SessionLocaleResolver();

        localeResolver.setDefaultLocale(new Locale("pl", "PL"));

        return localeResolver;

    }
}
