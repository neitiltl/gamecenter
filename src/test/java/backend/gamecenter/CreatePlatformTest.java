package backend.gamecenter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend.gamecenter.domain.Platform;
import backend.gamecenter.domain.PlatformRepository;

@DataJpaTest
public class CreatePlatformTest {

    @Autowired
    private PlatformRepository platformRepository;

    @Test
    public void createNewPlatform() {
        Platform platform = new Platform("Android");
        platformRepository.save(platform);
        assertThat(platform.getPlatformId()).isNotNull();
    }

}
