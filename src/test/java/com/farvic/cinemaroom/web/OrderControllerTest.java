package com.farvic.cinemaroom.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.farvic.cinemaroom.domain.Stats;
import com.farvic.cinemaroom.errors.OrderException;
import com.farvic.cinemaroom.service.OrderServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @MockBean
    private OrderServiceImpl mockOrderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetOrders() throws Exception {

        // Setup
        given(mockOrderService.getOrders()).willReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/orders")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        verify(mockOrderService).getOrders();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentLength()).isEqualTo(0);
    }

    @Test
    void testStatsEndpoint() throws Exception {

        // Setup
        Stats stats = new Stats(0, 81, 0);
        when(mockOrderService.getStats("super_secret")).thenReturn(stats);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/stats").queryParam("password", "super_secret")
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        String responseBody = response.getContentAsString();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(responseBody).isEqualTo(stats.toJsonString());

    }

    @Test
    void testStatsEndpoint_ThrowsOrderException() throws Exception {

        // Setup
        when(mockOrderService.getStats("password")).thenThrow(new OrderException("The password is wrong!", HttpStatus.UNAUTHORIZED));
//
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/stats")
                        .queryParam("password","password")
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        verify(mockOrderService).getStats("password");
        assertThat(response.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
        assertThat(response.getContentAsString()).isEqualTo("{\"error\":\"The password is wrong!\"}");
    }
}