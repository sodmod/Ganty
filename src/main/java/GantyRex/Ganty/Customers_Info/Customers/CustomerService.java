package GantyRex.Ganty.Customers_Info.Customers;

import GantyRex.Ganty.Customers_Info.Guarantors.GuarantorService;
import GantyRex.Ganty.Customers_Info.Guarantors.Guarantors;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final GuarantorService guarantorService;

    public String addCustomers(@NotNull Customers customers){
        signCustomers(
                new Customers(customers.getSurname(), customers.getFirstname(), customers.getEmail(), customers.getPhoneNumber(), customers.getAddress(), customers.getSTATE_OF_ORIGIN(), customers.getLCGA(), customers.getOccupation(), customers.getGuarantors(), customers.getNextOfKin())
        );
//        addGuarantors(new Guarantors();
//        String token =
       return null;
    }

    private String signCustomers(Customers customers){
        customerRepository.save(customers);
        return null;
    }
    private  String addGuarantors(Guarantors guarantors){
        guarantorService.addGuarantors(guarantors);
        return null;
    }
}
