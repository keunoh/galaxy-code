package com.kaltz.galaxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillEvansController {

    @GetMapping("/bill-evans")
    public String getBillEvans() {
        return "bill-evans";
    }
}
