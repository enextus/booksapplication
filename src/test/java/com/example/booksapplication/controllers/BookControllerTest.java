package com.example.booksapplication.controllers;

import java.util.logging.Logger;

import com.example.booksapplication.BooksApplication;
import com.example.booksapplication.services.BookService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BooksApplication.class })
@WebMvcTest(BookController.class)
//@AutoConfigureMockMvc
class BookControllerTest {

    private static final Logger log = Logger.getLogger(BookControllerTest.class.getName());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        log.info("Success");

    }

    @DisplayName("greetingShouldReturnMessageFromService Test")
    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(bookService.greet()).thenReturn("Hello, Mock");

        this.mockMvc.perform(get("/books-v1/hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }

    @DisplayName("hello Test")
    @Test
    public void hello() throws Exception {
        RequestBuilder requestBuilder = get("/books-v1/hello");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("Hello, Mock", result.getResponse().getContentAsString());
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods.");
    }


}
