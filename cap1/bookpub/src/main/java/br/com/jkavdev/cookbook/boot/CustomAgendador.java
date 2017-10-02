package br.com.jkavdev.cookbook.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.jkavdev.cookbook.boot.repository.BookRepository;

public class CustomAgendador {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private BookRepository bookRepository;

	//Estamos indicando um agendador, uma tarefa que sera executado de acordo
		//com um tempo definido, ao iniciar com intervalos de 10s
		//serao listados a quantidade de livros
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void bookCount() throws Exception {
		logger.info("Qtde de livros scheduled: " + bookRepository.count());
	}
	
	//Depois de 10s apos o iniciar da aplicacao com intervalos de 10s
		//serao deletados todos os livros
	@Scheduled(initialDelay = 10000, fixedRate = 10000)
	public void eraseBooks() throws Exception {
		logger.info("Deletando todos os livros: "); 
		bookRepository.deleteAll();
	}

}
