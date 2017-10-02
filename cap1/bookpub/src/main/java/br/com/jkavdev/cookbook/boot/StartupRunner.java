package br.com.jkavdev.cookbook.boot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.jkavdev.cookbook.boot.repository.BookRepository;

//CommandLineRunner nos prove um metodo que sera chamado
	//pelo spring boot apenas uma vez na aplicacao quando iniciada
public class StartupRunner implements CommandLineRunner {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//Podemos utilizar injecao de dependencias nos commandLiners
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	//Utilizando spring-data
	@Autowired
	private BookRepository bookRepository;

	//podemos utilizar esta funcionalidade para inicializar contextos
	//na inicializacao da aplicacao, mas o spring boot fornece outras funcionalidades
	//para isso
	
	//temos que ter cuidado com codigos executado aqui, pois uma vez lancado uma excecao
	//a aplicacao parara, por isso sempre executado o codigo dentro de um try-catch
	@Override
	public void run(String... args) throws Exception {
		logger.info("Bora que ta funcionando.............");
		
		logger.info("Datasource: " + ds.toString());
		
		//Utilizando jdbcTemplate, sql puras
		logger.info("Hora do banco: " + jdbc.queryForObject("select sysdate()", new Object[] {}, LocalDate.class)
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		logger.info("Qtde de Livros: " + bookRepository.count());
	}

}
