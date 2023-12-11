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
    private String questiontype;
    private boolean isrequired;
    private int min;
    private int max;

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "inquiryId")
    private Inquiry inquiry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnoreProperties("question")
    private List<Answer> answers;

    /* Constructors */

    public Question() {
    }

    public Question(String questiontext, Inquiry inquiry, String questiontype) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.inquiry = inquiry;
    }

    public Question(String questiontext, Inquiry inquiry, String questiontype, String questionoptions) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.inquiry = inquiry;
        this.questionoptions = questionoptions;
    }

    public Question(Long questionid, String questiontext, Inquiry inquiry, String questiontype) {
        this.questionid = questionid;
        this.questiontype = questiontype;
        this.questiontext = questiontext;
        this.inquiry = inquiry;
    }

    public Question(String questiontext, Inquiry inquiry, String questiontype, boolean isrequired) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.inquiry = inquiry;
        this.isrequired = isrequired;
    }

    public Question(String questiontext, Inquiry inquiry, String questiontype, String questionoptions,
            boolean isrequired) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.inquiry = inquiry;
        this.questionoptions = questionoptions;
        this.isrequired = isrequired;

    }

    public Question(String questiontext, String questiontype, int min, int max, Inquiry inquiry) {
        this.questiontext = questiontext;
        this.questiontype = questiontype;
        this.min = min;
        this.max = max;
        this.inquiry = inquiry;
    }

    /* Getters */

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

    public String getQuestiontype() {
        return questiontype;
    }

    public String getQuestionoptions() {
        return questionoptions;
    }

    public boolean isIsrequired() {
        return isrequired;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    /* Setters */

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

    public void setIsrequired(boolean isrequired) {
        this.isrequired = isrequired;
    }

    public void setQuestionoptions(String questionoptions) {
        this.questionoptions = questionoptions;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    /* toString */
    @Override
    public String toString() {
        return "Question questionid: " + questionid + ", questiontext: " + questiontext + ", inquiry: " + inquiry
                + ", questiontype: " + questiontype;
    }

}