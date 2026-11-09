package backend.gamecenter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backend.gamecenter.web.GameController;
import backend.gamecenter.web.PlatformController;

@SpringBootTest
class GamecenterApplicationTests {

	@Autowired
	private GameController gameController;

	@Autowired
	private PlatformController platformController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(gameController).isNotNull();
		assertThat(platformController).isNotNull();
	}

}
