package xyz.chenww.online_xdclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.chenww.online_xdclass.interceptor.LoginInterceptor;

/**
 * 功能描述：拦截配置
 *
 * @author chenweiwei
 * @since 2020/6/30
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截 api/v1/pri 路径
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                // 放行登录和注册接口
                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
