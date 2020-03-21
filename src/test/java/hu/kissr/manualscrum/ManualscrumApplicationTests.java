package hu.kissr.manualscrum;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManualscrumApplicationTests {

	@Test
	@DisplayName("Shoud be called like this")
	public void contextLoads() {
		System.out.println("I ran!!!!!!!!!!!!!!!!!!!!!");
	}

}
