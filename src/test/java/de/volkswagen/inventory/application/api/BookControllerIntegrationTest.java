package de.volkswagen.inventory.application.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class BookControllerIntegrationTest {

	@Autowired
	MockMvc mocMvc;

	@Test
	public void returnAllSavedBooksIntegrationTest() throws Exception {
		mocMvc.perform(get("/books")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(20)));

	}

	@Test
	public void returnBookByIsbnIntegarionTest() throws Exception {
		mocMvc.perform(get("/book/isbn/{isbn}", "1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.isbn",is("1")));
	}
}
