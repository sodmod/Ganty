package GantyRex.Ganty.Customers_Info.Guarantors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuarantorService {

    private final GuarantorsRepository guarantorsRepository;

    public String addGuarantors(Guarantors guarantors){
        guarantorsRepository.save(guarantors);
        return null;
    }

}
