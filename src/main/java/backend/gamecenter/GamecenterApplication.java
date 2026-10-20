package backend.gamecenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.gamecenter.domain.Game;
import backend.gamecenter.domain.GameRepository;

@SpringBootApplication
public class GamecenterApplication {
	private static final Logger log = LoggerFactory.getLogger(GamecenterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamecenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameRepository gameRepository) {
		return (args) -> {
			log.info("save games");
			gameRepository.save(new Game("The Legend of Zelda: Breath of the Wild", "Nintendo", 2017,
					"An open-world action-adventure game set in the kingdom of Hyrule."));
			gameRepository.save(new Game("Super Mario Odyssey", "Nintendo", 2017,
					"A 3D platformer where Mario travels across various kingdoms to rescue Princess Peach from Bowser."));

			log.info("fetch all games");
			for (Game game : gameRepository.findAll()) {
				log.info(game.toString());
			}
		};
	}
}
