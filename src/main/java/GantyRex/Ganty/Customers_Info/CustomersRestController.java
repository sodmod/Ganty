package GantyRex.Ganty.Customers_Info;

import GantyRex.Ganty.Customers_Info.Customers.CustomerService;
import GantyRex.Ganty.Customers_Info.Customers.Customers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "customer")
public class CustomersRestController {
    private final CustomerService customerService;

    @PostMapping(path = "add")
    @ResponseBody
    public String customers(Customers customers){
        return customerService.addCustomers(customers);
//        return "scu";
    }

}
