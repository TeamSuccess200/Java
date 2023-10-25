package hh.sof005.kyselypalvelu.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionid;
    private String questiontext;

    public Question() {
    }

    public Question(Long questionid, String questiontext) {
        this.questionid = questionid;
        this.questiontext = questiontext;
    }
   
    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }
 @Override
    public String toString() {
        return "Question [questionid=" + questionid + ", questiontext=" + questiontext + "]";
    }
}
