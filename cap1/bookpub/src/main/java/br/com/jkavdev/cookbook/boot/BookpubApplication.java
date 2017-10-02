package br.com.jkavdev.cookbook.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

//Anotacao que realiza toda a magica do spring boot
//ela define as seguintes anotacoes
//@Configuration - defini que esta classe contem definicoes de configuracoes
	//como beans, services, components
//@EnableAutoConfiguration - anotacao do spring boot, defini classes que instrui o spring boot
	//a configurar beans adicionais dependendo das classes no classpath da aplicacao
//@ComponentScan - indica que o spring adicionara os beans de acordo com a definicao dos
	//pacotes, por padrao ele aceita este pacote, onde estarao os beans da aplicacao
@SpringBootApplication
@EnableScheduling
public class BookpubApplication {
	
	//Comando para rodar a aplicacao com o maven
	//mvn spring-boot:run

	public static void main(String[] args) {
		//O metodo run cria um contexto do spring que le as anotacoes
		//definidas acima com @SpringBootApplication, e instancia o contexto criado
		//do mesmo jeito que seria se fosse ter que criar um contexto do spring manualmente
		SpringApplication.run(BookpubApplication.class, args);
	}
	
	//Definicao de um bean que sera gereciado pelo spring
	@Bean
	public StartupRunner schedulerRunner() {
		return new StartupRunner();
	}
	
	//Definicao de um agendador que realizara as tarefas por ele configuradas
	//Para tarefas o mais indicado sao beans anotados com @Scheduled
	@Bean
	public CustomAgendador contaLivrosAgendador() {
		return new CustomAgendador();
	}
}
