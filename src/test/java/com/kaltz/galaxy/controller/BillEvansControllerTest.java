package com.kaltz.galaxy.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BillEvansController.class)
class BillEvansControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("WaltzForDebby 악보를 호출한다.")
    @Test
    void getWaltzForDebby() throws Exception {
        mockMvc.perform(get("/bill-evans"))
                .andExpect(status().isOk())
                .andExpect(view().name("bill-evans"));
    }
}