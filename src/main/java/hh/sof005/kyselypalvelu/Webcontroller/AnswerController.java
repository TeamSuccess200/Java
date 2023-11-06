package hh.sof005.kyselypalvelu.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof005.kyselypalvelu.Domain.Answer;
import hh.sof005.kyselypalvelu.Domain.AnswerRepository;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;
import hh.sof005.kyselypalvelu.Domain.Question;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@Controller
public class AnswerController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    /* Lisää vastaus tiettyyn kysymykseen */
    @GetMapping("/addanswer/{questionid}")
    public String addAnswer(Model model, @PathVariable("questionid") Long questionid) {
        Question question = questionRepository.findById(questionid).orElse(null);

        Answer answer = new Answer();

        answer.setQuestion(question);

        model.addAttribute("answer", answer);
        return "addAnswer";
    }

    /* Tallenna vastaus tiettyn kysymekseen */
    @PostMapping("/saveanswer")
    public String saveAnswer(@ModelAttribute("answer") Answer answer) {

        answerRepository.save(answer);

        // Long questionid = answer.getQuestion().getQuestionid();
        Long inquiryId = answer.getQuestion().getInquiry().getInquiryId();

        return "redirect:/inquiry/" + inquiryId;

    }

}
