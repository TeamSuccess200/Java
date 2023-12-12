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
			Question question0 = new Question("Monennenko vuoden opiskelija olet?", testInquiry1, "radio",
					"1. vuoden, 2. vuoden, 3. vuoden, 4. vuoden, 5+ vuoden", true);
			Question question0A = new Question("Minkä suuntautumisen valitsit?", testInquiry1, "radio",
					"Ohjelmistokehitys, Digitaaliset palvelut, Infra, Liiketoiminta-ICT", true);
			Question question1 = new Question("Mitä mieltä olit kurssimateriaaleista?", testInquiry1, "radio",
					"Hyvät, Keskiverrot, Huonot", true);
			Question question2 = new Question("Mitä mieltä opetuksesta?", testInquiry1, "text", true);
			Question question3 = new Question("Mitä kehittäisit kurssitoteutuksessa?", testInquiry1, "text");
			Question question4 = new Question("Mistä tykkäsit erityisesti opetuksessa?", testInquiry1, "text", true);
			Question question5 = new Question("Miten arvioisit oman aktiivisuutesi kurssilla?", testInquiry1, "text");
			Question question6 = new Question("Anna vapaamuotoista palautetta kurssista: ", testInquiry1, "text");
			Question question7 = new Question("Minkä arvosanan antaisit itsellesi kurssista?", testInquiry1, "range", 1,
					5);

			qrepository.save(question0);
			qrepository.save(question0A);
			qrepository.save(question1);
			qrepository.save(question2);
			qrepository.save(question3);
			qrepository.save(question4);
			qrepository.save(question5);
			qrepository.save(question6);
			qrepository.save(question7);

			log.info("Save some answers to the testinquiry");
			Answer answer0 = new Answer("1. vuoden", question0);
			Answer answer00 = new Answer("2. vuoden", question0);
			Answer answer01 = new Answer("2. vuoden", question0);
			Answer answer02 = new Answer("4. vuoden", question0);
			Answer answer03 = new Answer("5+ vuoden", question0);
			Answer answer0A1 = new Answer("Ohjelmistokehitys", question0A);
			Answer answer0A2 = new Answer("Digitaaliset palvelut", question0A);
			Answer answer0A3 = new Answer("Ohjelmistokehitys", question0A);
			Answer answer0A4 = new Answer("Infra", question0A);
			Answer answer0A5 = new Answer("Ohjelmistokehitys", question0A);
			Answer answer1 = new Answer("Hyvät", question1);
			Answer answer1A = new Answer("Hyvät", question1);
			Answer answer1B = new Answer("Huonot", question1);
			Answer answer1C = new Answer("Keskiverrot", question1);
			Answer answer1D = new Answer("Keskiverrot", question1);
			Answer answer2 = new Answer("Opetus oli ok. Olisin halunnut käytännönläheisempää tekemistä.", question2);
			Answer answer2A = new Answer("Tykkäsin opetuksesta, opettaja oli innostunut opettamastaan aiheesta",
					question2);
			Answer answer2B = new Answer("Liikaa kotitehtäviä!", question2);
			Answer answer2C = new Answer("Olisin halunnut lisää esimerkkejä teoriaosuuksista", question2);
			Answer answer3 = new Answer("Vähentäisin ryhmätyöskentelyä ja lisäisin yksintyöskentelyä.", question3);
			Answer answer3A = new Answer("Teoriapowerpointteja voisi selventää, ne ovat aika sekavia.", question3);
			Answer answer3B = new Answer("Tunneilla pitäisi jättää aikaa ryhmätehtävien tekemiselle!", question3);
			Answer answer4 = new Answer("Tykkäsin opettajan innostuksesta asiaan liittyen.", question4);
			Answer answer4A = new Answer("Tykkäsin tehtävistä", question4);
			Answer answer4B = new Answer("Siitä että sai valita omat ryhmänsä", question4);
			Answer answer4C = new Answer("Ei ollut tenttiä!", question4);
			Answer answer5 = new Answer("Oma aktiivisuuteni oli ehkä 7/10-luokkaa.", question5);
			Answer answer5A = new Answer("Olin hyvin aktiivinen", question5);
			Answer answer5B = new Answer("Sairastuminen esti olemasta niin aktiivinen kuin halusin", question5);
			Answer answer5C = new Answer("Arvioisin sen loistavaksi", question5);
			Answer answer6 = new Answer(
					"Pitkiin diaesityksiin on vaikea jaksaa keskittyä, niitä voisi hieman tiivistää.", question6);
			Answer answer6A = new Answer(
					"Kiitos kivasta kurssista! Opin paljon", question6);
			Answer answer7 = new Answer(5, question7);
			Answer answer7A = new Answer(5, question7);
			Answer answer7B = new Answer(4, question7);
			Answer answer7C = new Answer(3, question7);
			Answer answer7D = new Answer(3, question7);

			arepository.save(answer1);
			arepository.save(answer1A);
			arepository.save(answer1B);
			arepository.save(answer1C);
			arepository.save(answer1D);
			arepository.save(answer2);
			arepository.save(answer2A);
			arepository.save(answer2B);
			arepository.save(answer2C);
			arepository.save(answer3);
			arepository.save(answer3A);
			arepository.save(answer3B);
			arepository.save(answer4);
			arepository.save(answer4A);
			arepository.save(answer4B);
			arepository.save(answer4C);
			arepository.save(answer5);
			arepository.save(answer5A);
			arepository.save(answer5B);
			arepository.save(answer5C);
			arepository.save(answer6);
			arepository.save(answer6A);
			arepository.save(answer0);
			arepository.save(answer00);
			arepository.save(answer01);
			arepository.save(answer02);
			arepository.save(answer03);
			arepository.save(answer0A1);
			arepository.save(answer0A2);
			arepository.save(answer0A3);
			arepository.save(answer0A4);
			arepository.save(answer0A5);
			arepository.save(answer7);
			arepository.save(answer7A);
			arepository.save(answer7B);
			arepository.save(answer7C);
			arepository.save(answer7D);

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
