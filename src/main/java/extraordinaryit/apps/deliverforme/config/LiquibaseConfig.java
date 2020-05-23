package extraordinaryit.apps.deliverforme.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.postgresql.ds.PGSimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@EnableMBeanExport
@EnableTransactionManagement
public class LiquibaseConfig {

    private static final Logger LOG = LoggerFactory.getLogger(LiquibaseConfig.class);

    @Value("${spring.datasource.host}")
    private String host;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.port}")
    private int port;

    @Value("${spring.datasource.databaseName}")
    private String databaseName;

    @Value("${spring.datasource.liquibase.changelog}")
    private String changeLogName;

    @Value("${spring.datasource.schemaName}")
    private String schema;

    @Value("${spring.datasource.liquibase.contexts}")
    private String liquibaseContext;

    @Value("${spring.datasource.ssl.enabled}")
    private boolean sslConnection;

    @Bean
    public DataSource getDataSource() {
        LOG.info(String.format("Data Source : CorteX database configuration : %n" +
                        "\thost : %s%n" +
                        "\tport : %s%n" +
                        "\tdb   : %s%n" +
                        "\tuser : %s%n" +
                        "\tssl  : %s%n"
                , host
                , port
                , databaseName
                , userName
                , sslConnection
        ));

        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();

        pgSimpleDataSource.setUser(userName);
        pgSimpleDataSource.setPassword(password);
        pgSimpleDataSource.setPortNumber(port);
        pgSimpleDataSource.setDatabaseName(databaseName);
        pgSimpleDataSource.setServerName(host);
        pgSimpleDataSource.setSsl(sslConnection);
        pgSimpleDataSource.setSslfactory("org.postgresql.ssl.NonValidatingFactory");

        HikariConfig config = new HikariConfig();
        config.setDataSource(pgSimpleDataSource);
        HikariDataSource ds = new HikariDataSource(config);

        return ds;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource loggingDbDataSource) {
        LOG.info(String.format("CorteX database configuration : %n" +
                        "\thost : %s%n" +
                        "\tport : %s%n" +
                        "\tdb   : %s%n" +
                        "\tuser : %s%n" +
                        "\tssl  : %s%n" +
                        "\tliquibaseContext  : %s%n"
                , host
                , port
                , databaseName
                , userName
                , sslConnection
                , liquibaseContext
        ));
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(loggingDbDataSource);
        liquibase.setChangeLog(changeLogName);
        liquibase.setContexts(liquibaseContext);
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("cortex.datasource.username=", userName);
        liquibase.setChangeLogParameters(parameters);

        return liquibase;
    }
}
