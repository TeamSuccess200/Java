package hh.sof005.kyselypalvelu.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
