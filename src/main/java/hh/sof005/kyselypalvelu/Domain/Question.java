package hh.sof005.kyselypalvelu.Domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionid;
    private String questiontext;
    private String questionoptions;

    public String getQuestionoptions() {
        return questionoptions;
    }

    public void setQuestionoptions(String questionoptions) {
        this.questionoptions = questionoptions;
    }

    private String questiontype;

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "inquiryId")
    private Inquiry inquiry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnoreProperties("question")
    private List<Answer> answers;

    public Question() {
    }

    public Question(String questiontext, Inquiry inquiry, String questiontype) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.inquiry = inquiry;
        this.questiontype = questiontype;
    }

    public Question(Long questionid, String questiontext, Inquiry inquiry, String questiontype) {
        this.questionid = questionid;
        this.questiontype = questiontype;
        this.questiontext = questiontext;
        this.inquiry = inquiry;
        this.questiontype = questiontype;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question questionid: " + questionid + ", questiontext: " + questiontext + ", inquiry: " + inquiry + ", questiontype: " + questiontype;
    }

}