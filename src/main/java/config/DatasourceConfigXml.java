package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"templete"})
@ImportResource(locations = {"classpath:ActiveProfiles.xml"})
public class DatasourceConfigXml {
}
