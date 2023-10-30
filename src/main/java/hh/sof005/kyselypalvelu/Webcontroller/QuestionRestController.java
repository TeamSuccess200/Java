package hh.sof005.kyselypalvelu.Webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hh.sof005.kyselypalvelu.Domain.Question;
import hh.sof005.kyselypalvelu.Domain.QuestionRepository;

@Controller
public class QuestionRestController {

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public @ResponseBody List<Question> questionListRest() {
        return (List<Question>) questionRepository.findAll();
    }

    @RequestMapping(value = "/questions/id", method = RequestMethod.GET)
    public Optional<Question> findQuestionRest(@PathVariable("id") Long questionid) {
        return questionRepository.findById(questionid);
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public @ResponseBody Question saveQuestionRest(@RequestBody Question question) {
        return questionRepository.save(question);
    }
}
