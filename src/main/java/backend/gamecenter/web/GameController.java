package backend.gamecenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @RequestMapping("/index")
    @ResponseBody
    public String returnIndex() {
        return "Indeksi!";
    }

}
