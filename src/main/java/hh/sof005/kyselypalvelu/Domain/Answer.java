package hh.sof005.kyselypalvelu.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;

    private String answertext;

    @ManyToOne
    @JoinColumn(name = "questionid")
    @JsonIgnoreProperties("answers")
    private Question question;

    /* Constructors */

    public Answer() {
    }

    public Answer(String answertext, Question question) {
        this.answertext = answertext;
        this.question = question;
    }

    public Answer(String answertext) {
        this.answertext = answertext;
    }

    /* Setters */

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public void setAnswertext(String answertext) {
        this.answertext = answertext;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    /* Getters */

    public Long getAnswerId() {
        return answerId;
    }

    public String getAnswertext() {
        return answertext;
    }

    public Question getQuestion() {
        return question;
    }

    /* toString */

    @Override
    public String toString() {
        return "Answer answerId: " + answerId + ", answertext: " + answertext;
    }

}
