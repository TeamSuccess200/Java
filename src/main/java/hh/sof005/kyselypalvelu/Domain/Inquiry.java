package hh.sof005.kyselypalvelu.Domain;

public class Inquiry {
    private Long inquiryId;
    private String name;
    private String description;
    // private List<Question> questions;

    public Long getInquiryId() {
        return inquiryId;
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

    public Inquiry() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
