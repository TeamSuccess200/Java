package hh.sof005.kyselypalvelu.Domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquiryId;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inquiry")
    @JsonIgnoreProperties("inquiry")
    private List<Question> questions;

    /* Constructors */

    public Inquiry() {
    }

    public Inquiry(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Inquiry(Long inquiryId, String name, String description) {
        this.inquiryId = inquiryId;
        this.name = name;
        this.description = description;
    }

    /* Getters */

    public Long getInquiryId() {
        return inquiryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    /* Setters */

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /* toString */

    @Override
    public String toString() {
        return "Inquiry inquiryId: " + inquiryId + ", name: " + name + ", description: " + description;
    }
}