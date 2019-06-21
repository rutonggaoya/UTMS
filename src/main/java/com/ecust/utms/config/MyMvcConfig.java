package com.ecust.utms.config;

<<<<<<< HEAD
import com.ecust.utms.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
=======
import com.ecust.utms.Component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
>>>>>>> f0f3399fab466a2ac84b320d92a9bd4e7a02245a
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("message");
    }

<<<<<<< HEAD
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

=======
>>>>>>> f0f3399fab466a2ac84b320d92a9bd4e7a02245a
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
//    }
}

