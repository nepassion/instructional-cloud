package org.example.web;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${kal}")
    private String val;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return val;
    }

    @PutMapping("/users/{id}/deduction/{money}")
    public String deductionMoney(
            @PathVariable("id") Long id,
            @PathVariable("money") Double money) {
        int flag = userService.deductionBalance(id, money);
        if (flag == 1) {
            return "update failure";
        }
        return "update success";
    }
}
