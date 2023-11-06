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
			Inquiry testInquiry1 = new Inquiry("Kurssipalaute", "Anna palautetta kurssista");
			irepository.save(testInquiry1);

			Inquiry testInquiry2 = new Inquiry("Lemmikkikysely", "Kerro lemmikistäsi");
			irepository.save(testInquiry2);

			log.info("Save some questions to the testinquiry");
			Question question1 = new Question("Mitä mieltä olit kurssimateriaaleista?", testInquiry1);
			Question question2 = new Question("Mitä mieltä opetuksesta?", testInquiry1);
			Question question3 = new Question("Mitä kehittäisit kurssitoteutuksessa?", testInquiry1);
			Question question4 = new Question("Mistä tykkäsit erityisesti opetuksessa?", testInquiry1);
			Question question5 = new Question("Miten arvioisit oman aktiivisuutesi kurssilla?", testInquiry1);
			Question question6 = new Question("Anna vapaamuotoista palautetta kurssista: ", testInquiry1);

			qrepository.save(question1);
			qrepository.save(question2);
			qrepository.save(question3);
			qrepository.save(question4);
			qrepository.save(question5);
			qrepository.save(question6);

			log.info("Save somw questions to the testinquiry2");
			Question question10 = new Question("What is your pets name?", testInquiry2);
			Question question11 = new Question("How old is your pet?", testInquiry2);

			qrepository.save(question10);
			qrepository.save(question11);
		};
	}

}
