package hh.sof005.kyselypalvelu.Webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof005.kyselypalvelu.Domain.Answer;
import hh.sof005.kyselypalvelu.Domain.AnswerRepository;

@CrossOrigin
@Controller
public class AnswerRestController {

    @Autowired
    private AnswerRepository answerRepository;

    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public @ResponseBody List<Answer> answerListRest() {
        return (List<Answer>) answerRepository.findAll();
    }

    @RequestMapping(value = "/answers/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Answer> findAnswerRest(@PathVariable("id") Long answerId) {
        return answerRepository.findById(answerId);
    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public @ResponseBody Answer saveAnswerRest(@RequestBody Answer answer) {
        System.out.println("Received answer: " + answer);
        return answerRepository.save(answer);
    }

}
