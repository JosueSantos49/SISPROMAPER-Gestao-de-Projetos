package br.com.tkcsapcd.model.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.tkcsapcd.model.helper.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourcecCP {
	
	private static DataSourcecCP	datasource;
    private ComboPooledDataSource cpds;

    private DataSourcecCP() throws IOException, SQLException, PropertyVetoException {
    	
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(Config.getDriver()); //loads the jdbc driver
        cpds.setJdbcUrl(Config.getHost());
        cpds.setUser(Config.getUsuarioBanco());
        cpds.setPassword(Config.getSenhaBanco());   
        
        cpds.setInitialPoolSize(0);//# Número de conexõs que o pool tentará adiquirur durante a inicialização. Deve ser um número entre  minPoolSize e maxPoolSize.
        cpds.setMinPoolSize(0);//# Número mínimo de conexões que o pool irá manter.
        cpds.setMaxPoolSize(15);//# Número máximo de conexões que o pool irá manter.
        cpds.setMaxIdleTime(60);//Segundos que uma conexão a ser mantida no pool sem ser usada, antes de ser descartada. Zero significa que nunca expira.
        cpds.setMaxStatements(0);// OBS: estava (180), valor alterado para (0) http://www.mchange.com/projects/c3p0/#configuring_statement_pooling
        cpds.setMaxStatementsPerConnection(10); 
        cpds.setAcquireIncrement(1);//Determina quantas conexões em um c3p0 vez vai tentar adquirir quando a piscina está esgotado. 
        cpds.setIdleConnectionTestPeriod(1);//Se este é um número maior que 0, c3p0 irá testar todas as conexões ociosas, reunidas, mas não verificados-out, toda esta série de segundos.
        cpds.setCheckoutTimeout(5000);//O número de milissegundos um cliente chamando getConnection () irá esperar por uma conexão para ser o check-in ou adquirida quando a piscina está esgotado.
        cpds.setAcquireRetryDelay(1000);//Tempo em milisegundos que o c3p0 irá esperar entre tentivas de aquisição.
        cpds.setAcquireRetryAttempts(5);//# Define quantas vezes o c3p0 tentará adquirir uma nova Conexão da base de dados antes de desistir. Se esse valor é menor ou igual a zero, c3p0 tentará adquirir uma nova conexão indefinidamente.
        cpds.setBreakAfterAcquireFailure(false);//# vezes. Se falso, o fracasso para obter uma Conexão jogará uma exceção, porém o DataSource permanecerá valido, e tentará adquirir novamente, seguindo uma nova chamada para getConnection().
        cpds.setMaxIdleTimeExcessConnections(30);//# Número de segundos que conexões acima do limite minPoolSize deverão permanecer inativas no pool antes de serem fechadas. Destinado para aplicações que desejam reduzir agressivamente o número de conexões abertas
        cpds.setNumHelperThreads(3);//# helper threads que não detém travas de fechamento. Separar essas operações atravéz de múltiplas threads pode melhorar significativamente a performace, permitindo que várias operações sejam executadas ao mesmo tempo.
        cpds.setDebugUnreturnedConnectionStackTraces(false);//# Este paramêtro deveria ser setado apenas para debugar a aplicação, já que capturar o stack trace deixa mais o lento o precesso de check-out de Conexões.
        cpds.setUnreturnedConnectionTimeout(0);//# Use esta funcionalidade temporariamente em combinação com  debugUnreturnedConnectionStackTraces para descobrir onde as conexões esão vazando!
                              
    }

    public static DataSourcecCP getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSourcecCP();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
