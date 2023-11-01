package hh.sof005.kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof005.kyselypalvelu.Domain.Inquiry;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;
import hh.sof005.kyselypalvelu.Domain.Question;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);

	}

	@Bean
	public CommandLineRunner inquiryDemo(InquiryRepository irepository, QuestionRepository qrepository) {
		return (args) -> {
			log.info("Save some inquiries");
			Inquiry testInquiry1 = new Inquiry("Henkilötietokysely", "Anna kaikki tietosi");
			irepository.save(testInquiry1);

			Inquiry testInquiry2 = new Inquiry("Lemmikkikysely", "Kerro lemmikistäsi");
			irepository.save(testInquiry2);

			log.info("Save somw questions to the testinquiry");
			Question question1 = new Question("What is your name?", testInquiry1);
			Question question2 = new Question("How old are you?", testInquiry1);

			qrepository.save(question1);
			qrepository.save(question2);

			log.info("Save somw questions to the testinquiry2");
			Question question3 = new Question("What is your pets name?", testInquiry2);
			Question question4 = new Question("How old is your pet?", testInquiry2);

			qrepository.save(question3);
			qrepository.save(question4);
		};
	}

}
