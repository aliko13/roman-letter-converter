package com.example.converter.controller;

import com.example.converter.enums.ConverterType;
import com.example.converter.service.ConvertServiceGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(NumberConversionController.class)
public class NumberConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConvertServiceGateway convertServiceGateway;

    @Test
    public void testConvertNumber() throws Exception {
        // given
        String input = "123";
        ConverterType type = ConverterType.DECIMAL;
        String romanString = "CXXIII";

        when(convertServiceGateway.convertToRomanNumeral(input, type)).thenReturn(romanString);

        // when / then
        String contentAsString = mockMvc.perform(get("/convert")
                .param("input", input)
                .param("type", String.valueOf(type))
                ).andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(contentAsString).isEqualTo(romanString);
    }
}
