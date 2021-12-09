package tacos;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomepage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())                           // 응답은 반드시 200이어야 함
                .andExpect(view().name("home"))      // 뷰 이름은 home 이어야 함
                .andExpect(content().string(
                        containsString("Welcome to...")));   // 브라우저에 보이는 뷰에는 반드시 'Welcome to...' 텍스트가 포함되어야 함
    }
}
