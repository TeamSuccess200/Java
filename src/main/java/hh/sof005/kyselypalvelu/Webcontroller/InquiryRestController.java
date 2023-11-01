package hh.sof005.kyselypalvelu.Webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof005.kyselypalvelu.Domain.Inquiry;
import hh.sof005.kyselypalvelu.Domain.InquiryRepository;

@Controller
public class InquiryRestController {

    @Autowired
    InquiryRepository inquiryRepository;

    @RequestMapping(value = "/inquiries", method = RequestMethod.GET)
    public @ResponseBody List<Inquiry> inquiryListRest() {
        return (List<Inquiry>) inquiryRepository.findAll();
    }

    @RequestMapping(value = "/inquiries/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Inquiry> findQuestionRest(@PathVariable("id") Long inquiryid) {
        return inquiryRepository.findById(inquiryid);
    }

    @RequestMapping(value = "/inquiries", method = RequestMethod.POST)
    public @ResponseBody Inquiry saveInquiryRest(@RequestBody Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }
}
