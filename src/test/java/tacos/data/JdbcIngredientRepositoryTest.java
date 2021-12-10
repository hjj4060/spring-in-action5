package tacos.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import tacos.Ingredient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcIngredientRepositoryTest {

    @Autowired
    JdbcIngredientRepository jdbcIngredientRepository;
/*
    JUnit5에서 DI가 스스로 지원함
    @BeforeEach
    public void beforeEach(JdbcTemplate jdbc) {
        jdbcIngredientRepository = new JdbcIngredientRepository(jdbc);
    }
*/
    @Test
    public void 전체재료조회() {
        List list = (List)jdbcIngredientRepository.findAll();
        System.out.println(list.toString());
}

    @Test
    public void 재료추가() {
        Ingredient ingredient = new Ingredient("test", "test", Ingredient.Type.PROTEIN);

        jdbcIngredientRepository.save(ingredient);

        jdbcIngredientRepository.findById("test");
    }
}