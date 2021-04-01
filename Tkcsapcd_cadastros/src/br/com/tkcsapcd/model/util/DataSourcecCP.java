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
        
        cpds.setInitialPoolSize(0);//# N�mero de conex�s que o pool tentar� adiquirur durante a inicializa��o. Deve ser um n�mero entre  minPoolSize e maxPoolSize.
        cpds.setMinPoolSize(0);//# N�mero m�nimo de conex�es que o pool ir� manter.
        cpds.setMaxPoolSize(15);//# N�mero m�ximo de conex�es que o pool ir� manter.
        cpds.setMaxIdleTime(60);//Segundos que uma conex�o a ser mantida no pool sem ser usada, antes de ser descartada. Zero significa que nunca expira.
        cpds.setMaxStatements(0);// OBS: estava (180), valor alterado para (0) http://www.mchange.com/projects/c3p0/#configuring_statement_pooling
        cpds.setMaxStatementsPerConnection(10); 
        cpds.setAcquireIncrement(1);//Determina quantas conex�es em um c3p0 vez vai tentar adquirir quando a piscina est� esgotado. 
        cpds.setIdleConnectionTestPeriod(1);//Se este � um n�mero maior que 0, c3p0 ir� testar todas as conex�es ociosas, reunidas, mas n�o verificados-out, toda esta s�rie de segundos.
        cpds.setCheckoutTimeout(5000);//O n�mero de milissegundos um cliente chamando getConnection () ir� esperar por uma conex�o para ser o check-in ou adquirida quando a piscina est� esgotado.
        cpds.setAcquireRetryDelay(1000);//Tempo em milisegundos que o c3p0 ir� esperar entre tentivas de aquisi��o.
        cpds.setAcquireRetryAttempts(5);//# Define quantas vezes o c3p0 tentar� adquirir uma nova Conex�o da base de dados antes de desistir. Se esse valor � menor ou igual a zero, c3p0 tentar� adquirir uma nova conex�o indefinidamente.
        cpds.setBreakAfterAcquireFailure(false);//# vezes. Se falso, o fracasso para obter uma Conex�o jogar� uma exce��o, por�m o DataSource permanecer� valido, e tentar� adquirir novamente, seguindo uma nova chamada para getConnection().
        cpds.setMaxIdleTimeExcessConnections(30);//# N�mero de segundos que conex�es acima do limite minPoolSize dever�o permanecer inativas no pool antes de serem fechadas. Destinado para aplica��es que desejam reduzir agressivamente o n�mero de conex�es abertas
        cpds.setNumHelperThreads(3);//# helper threads que n�o det�m travas de fechamento. Separar essas opera��es atrav�z de m�ltiplas threads pode melhorar significativamente a performace, permitindo que v�rias opera��es sejam executadas ao mesmo tempo.
        cpds.setDebugUnreturnedConnectionStackTraces(false);//# Este param�tro deveria ser setado apenas para debugar a aplica��o, j� que capturar o stack trace deixa mais o lento o precesso de check-out de Conex�es.
        cpds.setUnreturnedConnectionTimeout(0);//# Use esta funcionalidade temporariamente em combina��o com  debugUnreturnedConnectionStackTraces para descobrir onde as conex�es es�o vazando!
                              
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
