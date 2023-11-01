package hh.sof005.kyselypalvelu.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionid;
    private String questiontext;

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "inquiryId")
    private Inquiry inquiry;

    public Question() {
    }

    public Question(String questiontext, Inquiry inquiry) {
        this.questiontext = questiontext;
        this.inquiry = inquiry;
    }

    public Question(Long questionid, String questiontext, Inquiry inquiry) {
        this.questionid = questionid;
        this.questiontext = questiontext;
        this.inquiry = inquiry;
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

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    @Override
    public String toString() {
        return "Question [questionid=" + questionid + ", questiontext=" + questiontext + ", inquiry=" + inquiry + "]";
    }
}