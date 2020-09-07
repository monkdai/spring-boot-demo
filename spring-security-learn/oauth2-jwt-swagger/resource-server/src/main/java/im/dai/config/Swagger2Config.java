package im.dai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Swagger2Config
 * @author: roc
 * @date: 2020/9/7 下午 05:46
 * @version: 1.0
 * @description: 请求头加参数，认证方式一
 * 这种方式比较通用，不仅仅适用于 OAuth2，也适用于其他一些自定义的 token 登录方式
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 配置一个 Docket Bean，这个 Bean 中，配置映射路径和要扫描的接口的位置
     */
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("im.dai.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContexts()))
                .securitySchemes(Arrays.asList(securitySchemes()))
                //主要配置一下 Swagger2 文档网站的信息
                .apiInfo(new ApiInfoBuilder()
                        .description("接口文档的描述信息")
                        .title("接口文档")
                        .contact(new Contact("daiim","http://dai.im","daiim@qq.com"))
                        .version("v1.0")
                        .license("Apache2.0")
                        .build());
    }

    /**
     * securitySchemes 来配置全局参数，这里的配置是一个名为 Authorization 的请求头（OAuth2 中需要携带的请求头）
     */
    //private SecurityScheme securitySchemes() {
    //    return new ApiKey("Authorization", "Authorization", "header");
    //}

    /**
     * securityContexts 则用来配置有哪些请求需要携带 Token，这里我们配置了所有请求
     */
    //private SecurityContext securityContexts() {
    //    return SecurityContext.builder()
    //            .securityReferences(defaultAuth())
    //            .forPaths(PathSelectors.any())
    //            .build();
    //}
    //
    //private List<SecurityReference> defaultAuth() {
    //    AuthorizationScope authorizationScope = new AuthorizationScope("xxx", "描述信息");
    //    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    //    authorizationScopes[0] = authorizationScope;
    //    return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    //}

    /**
     * 这种方式最大的好处就是不用通过其他途径获取 access_token，直接在 swagger-ui 页面输入 password 模式的认证参数即可。
     * 非常方便，仅限于 OAuth2 模式。
     */
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("all", "all scope")
        };
    }

    private SecurityScheme securitySchemes() {
        GrantType grant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8080/oauth/token");
        return new OAuthBuilder().name("OAuth2")
                .grantTypes(Arrays.asList(grant))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    private SecurityContext securityContexts() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("OAuth2", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }
}
