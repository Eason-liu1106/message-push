package com.config.apiconfig;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.service.Tag;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author JialinLiu
 * @date 2018/10/22 0022 10:44
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.*.web")
public class ApiConfig implements WebMvcConfigurer {
    /**
     * 文档信息
     */
    private ApiInfo apiInfo = new ApiInfoBuilder()
            .title("消息推送接口API文档")
            .description("描述：Restful风格<br >")
            .version("1.0.0")
            .build();
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("message.com")
                 //文档信息
                .apiInfo(apiInfo)
                 //对@ApiOperation中定义的标签进行统一描述
                //.tags(new Tag("用户管理", "用户相关操作"))
                .select()
                // 过滤-注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 过滤-路径
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
