package NewsProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class PostSecurity extends WebSecurityConfigurerAdapter {
    //Бин для подключения к БД
//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //запросы доступны всем
        http.authorizeRequests()
                //детали видно только админу
                .antMatchers("/listadmin/**").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
                //перенаправление на форму логига
                .and().formLogin().loginPage("/login").permitAll()
                //отправка логина-пароля по url
                .loginProcessingUrl("/checkuser");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Bob").password("1234").roles("ADMIN");
    }
}
