package misl.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import misl.config.ConfigLoader;

@Component
public class HikariCPDataSource {

	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		ConfigLoader cl = new ConfigLoader();
		String DB_SERVER = cl.getProp("db.server");
		String DB_PORT = cl.getProp("db.port");
		String DB_USERNAME = cl.getProp("db.username"); 
		String DB_PASSWORD = cl.getProp("db.password");
		String DB_NAME = cl.getProp("db.name");
		
		config.setLeakDetectionThreshold(3600000); // 1 hour
		//config.setMinimumIdle(5);
		config.setMaximumPoolSize(5);
		config.setConnectionTestQuery("/* ping */ SELECT 1");
		config.setConnectionTimeout(180000); // 30 sec
		//config.setMaxLifetime(1800000); // 30 mins
		//config.setIdleTimeout(300000); // 5 mins
		config.setPoolName("HikariPool-1");
		config.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		config.addDataSourceProperty("serverName", DB_SERVER);
		config.addDataSourceProperty("portNumber", DB_PORT);
		config.addDataSourceProperty("user", DB_USERNAME);
		config.addDataSourceProperty("password", DB_PASSWORD);
		config.addDataSourceProperty("databaseName", DB_NAME);
		return config;
	}
	
	
    public static HikariDataSource ds = null;

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    @PostConstruct
    public void init() {
    	try {
    		ds = new HikariDataSource(hikariConfig());
    	}catch (Exception e) {
			System.err.println("Can't Start Hikari");
		}
    }
    
    @PreDestroy
    public void shutDown() {
	    ds.close();
    }
}
