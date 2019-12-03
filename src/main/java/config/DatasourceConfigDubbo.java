package config;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"templete"})
@ImportResource(locations = {"classpath:consumer.xml"})
public class DatasourceConfigDubbo {
    @Bean
    @Profile("qa")
    public DataSource dataSource1() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://rm-bp1735ib5kt16n0mzpo.mysql.rds.aliyuncs.com:3306/koala?characterEncoding=utf8&useSSL=true&nullCatalogMeansCurrent=true");
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("koala");
        basicDataSource.setPassword("@tianli123456TL");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(30);
        return basicDataSource;
    }
}
