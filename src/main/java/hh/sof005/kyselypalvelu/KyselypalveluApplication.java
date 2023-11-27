package hh.sof005.kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof005.kyselypalvelu.Domain.Answer;
import hh.sof005.kyselypalvelu.Domain.AnswerRepository;
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
	public CommandLineRunner inquiryDemo(InquiryRepository irepository, QuestionRepository qrepository,
			AnswerRepository arepository) {
		return (args) -> {
			log.info("Save some inquiries");
			Inquiry testInquiry1 = new Inquiry("Kurssipalaute", "Anna palautetta kurssista");
			irepository.save(testInquiry1);

			Inquiry testInquiry2 = new Inquiry("Lemmikkikysely", "Kerro lemmikistäsi");
			irepository.save(testInquiry2);

			log.info("Save some questions to the testinquiry");
			Question question1 = new Question("Mitä mieltä olit kurssimateriaaleista?", testInquiry1, "radio", "Hyvät, Keskiverrot, Huonot");
			Question question2 = new Question("Mitä mieltä opetuksesta?", testInquiry1, "text");
			Question question3 = new Question("Mitä kehittäisit kurssitoteutuksessa?", testInquiry1, "text");
			Question question4 = new Question("Mistä tykkäsit erityisesti opetuksessa?", testInquiry1, "text");
			Question question5 = new Question("Miten arvioisit oman aktiivisuutesi kurssilla?", testInquiry1, "text");
			Question question6 = new Question("Anna vapaamuotoista palautetta kurssista: ", testInquiry1, "text");

			qrepository.save(question1);
			qrepository.save(question2);
			qrepository.save(question3);
			qrepository.save(question4);
			qrepository.save(question5);
			qrepository.save(question6);

			log.info("Save some answers to the testinquiry");
			Answer answer1 = new Answer("Hyvät", question1);
			Answer answer2 = new Answer("Opetus oli ok. Olisin halunnut käytännönläheisempää tekemistä.", question2);
			Answer answer3 = new Answer("Vähentäisin ryhmätyöskentelyä ja lisäisin yksintyöskentelyä.", question3);
			Answer answer4 = new Answer("Tykkäsin opettajan innostuksesta asiaan liittyen.", question4);
			Answer answer5 = new Answer("Oma aktiivisuuteni oli ehkä 7/10-luokkaa.", question5);
			Answer answer6 = new Answer(
					"Pitkiin diaesityksiin on vaikea jaksaa keskittyä, niitä voisi hieman tiivistää.", question6);

			arepository.save(answer1);
			arepository.save(answer2);
			arepository.save(answer3);
			arepository.save(answer4);
			arepository.save(answer5);
			arepository.save(answer6);

			log.info("Save some questions to the testinquiry2");
			Question question10 = new Question("What is your pets name?", testInquiry2, "text");
			Question question11 = new Question("How old is your pet?", testInquiry2, "text");

			qrepository.save(question10);
			qrepository.save(question11);

			log.info("Save some answers to the testinquiry2");
			Answer answer10 = new Answer("My pet's name is Alpo", question10);
			Answer answer11 = new Answer("Alpo is two-years old", question11);

			arepository.save(answer10);
			arepository.save(answer11);
		};
	}

}
