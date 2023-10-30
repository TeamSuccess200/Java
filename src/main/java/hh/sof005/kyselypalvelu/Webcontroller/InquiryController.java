package hh.sof005.kyselypalvelu.Webcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof005.kyselypalvelu.Domain.Inquiry;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;

@Controller
public class InquiryController {

    @Autowired
    private InquiryRepository inquiryRepository;

    /* Listaa kyselyt */
    @GetMapping("/inquiryList")
    public String listInquiries(Model model) {
        model.addAttribute("inquiries", inquiryRepository.findAll());
        return "inquiryList";
    }

    /* Lisää kysely */
    @GetMapping("/addInquiry")
    public String addInquiry(Model model) {
        model.addAttribute("inquiry", new Inquiry());
        return "addInquiry";
    }

    /* Tallenna kysely */
    @PostMapping("/saveInquiry")
    public String saveInquiry(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        return "redirect:/inquiryList";
    }

    /* Näytä kysely */
    @GetMapping("/inquiry/{id}")
    public String showInquiry(@PathVariable("id") Long inquiryId, Model model) {
        // Inquiry inquiry1 = inquiryRepository.findById(inquiryId);
        // model.addAttribute("inquiry", inquiryRepository.findById(inquiryId));
        model.addAttribute(inquiryRepository.findById(inquiryId));
        return "inquiry";
    }
}
