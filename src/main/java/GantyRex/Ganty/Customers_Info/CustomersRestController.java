package GantyRex.Ganty.Customers_Info;

import GantyRex.Ganty.Customers_Info.Customers.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "customer")
public class CustomersRestController {
    private final CustomerService customerService;

    @PostMapping(path = "add")
    @ResponseBody
    public String customers(@RequestBody CustomerRequest customers){
        return customerService.addCustomers(customers);
//        return "scu";
    }

}
