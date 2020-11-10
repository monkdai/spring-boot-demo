package im.dai.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: roc
 * @date: 2020/9/11 下午 04:15
 * @description: MyBatis Plus配置类
 */
@EnableTransactionManagement //树管理
@Configuration
@MapperScan("im.dai.mapper") //比起@Mapper，这种方式更好，扫描一次就行
public class MpConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //分页的拦截器对象
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}

