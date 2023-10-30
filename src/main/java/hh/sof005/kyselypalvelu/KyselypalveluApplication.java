package hh.sof005.kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof005.kyselypalvelu.Domain.Inquiry;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);


		// Testikommentti
	}

	@Bean
	public CommandLineRunner inquiryDemo(InquiryRepository irepository, QuestionRepository qrepository) {
		return (args) -> {
			log.info("Save some inquiries");
			Inquiry testInquiry1 = new Inquiry("Testi", "Testikysely");
			irepository.save(testInquiry1);
		};
	}

}
