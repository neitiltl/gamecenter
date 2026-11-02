package backend.gamecenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;
import backend.gamecenter.domain.Platform;
import backend.gamecenter.domain.PlatformRepository;
import backend.gamecenter.domain.User;
import backend.gamecenter.domain.UserRepository;

@SpringBootApplication
public class GamecenterApplication {
	private static final Logger log = LoggerFactory.getLogger(GamecenterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamecenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameRepository gameRepository, PlatformRepository platformRepository,
			UserRepository userRepository) {
		return (args) -> {

			log.info("save platforms");
			Platform platform1 = new Platform("PC");
			Platform platform2 = new Platform("PlayStation");
			Platform platform3 = new Platform("Xbox");
			Platform platform4 = new Platform("Nintendo");
			Platform platform5 = new Platform("Card Game");
			Platform platform6 = new Platform("Board Game");

			platformRepository.save(platform1);
			platformRepository.save(platform2);
			platformRepository.save(platform3);
			platformRepository.save(platform4);
			platformRepository.save(platform5);
			platformRepository.save(platform6);

			log.info("save games");
			gameRepository.save(new Game("The Legend of Zelda: Breath of the Wild", "Nintendo", 2017,
					"An open-world action-adventure game set in the kingdom of Hyrule.", platform4));
			gameRepository.save(new Game("Super Mario Odyssey", "Nintendo", 2017,
					"A 3D platformer where Mario travels across various kingdoms to rescue Princess Peach from Bowser.",
					platform4));

			log.info("fetch all games");
			for (Game game : gameRepository.findAll()) {
				log.info(game.toString());
			}

			log.info("fetch all platforms");
			for (Platform platform : platformRepository.findAll()) {
				log.info(platform.toString());
			}

			log.info("fetch all games");
			for (Game game : gameRepository.findAll()) {
				log.info(game.toString());
			}

			User user1 = new User("maija", "$2a$10$pwCDX1OhyXh.Vw.DOIxIPOXOpo8Vbx3jAZm8T2zh6Zosd58CRPXLa", "ADMIN");
			User user2 = new User("matti", "$2a$10$id./NxBgeF16H31oWID9me1r6Ucg4y/COO9gTYkaYXI7riJCkdrZC", "USER");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}
}
