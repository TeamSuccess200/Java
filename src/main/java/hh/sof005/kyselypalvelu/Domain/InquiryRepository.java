package hh.sof005.kyselypalvelu.Domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InquiryRepository extends CrudRepository<Inquiry, Long> {
    List<Inquiry> findByName(String name);
}
