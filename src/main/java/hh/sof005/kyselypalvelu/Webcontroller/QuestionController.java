package hh.sof005.kyselypalvelu.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof005.kyselypalvelu.Domain.Question;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestion";
    }

    @PostMapping("/savequestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        questionRepository.save(question);
        return "redirect:/inquiryList";
    }

}
