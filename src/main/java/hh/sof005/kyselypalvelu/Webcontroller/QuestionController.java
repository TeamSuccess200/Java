package hh.sof005.kyselypalvelu.Webcontroller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import hh.sof005.kyselypalvelu.Domain.Inquiry;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;
import hh.sof005.kyselypalvelu.Domain.Question;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    /* Lisää kysymys tiettyyn kyselyyn */
    @GetMapping("/addquestion/{inquiryId}")
    public String addQuestion(Model model, @PathVariable("inquiryId") Long inquiryId) {
        // Luodaan Question-olio, luodaan olion Inquiry-attribuutti-olio
        // Inquiry-attribuutti-oliolle asetetaan pyynnössä tullut inquiryId-arvo
        Question question = new Question();

        model.addAttribute("question", question);
        return "addQuestion";
    }

    /* tallenna kysymys */
    @PostMapping("/savequestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        System.out.println("Question: " + question);
        /*
         * Long inquiryId = question.getInquiry().getInquiryId();
         * Optional<Inquiry> inquiryOptional = inquiryRepository.findById(inquiryId);
         * Inquiry savedInquiry = inquiryOptional.get();
         * question.setInquiry(savedInquiry);
         */

        questionRepository.save(question);
        return "redirect:/inquiryList";
        // return "redirect:/inquiry/" + inquiryId;
    }

    /* Näytä kysymykset */
}
