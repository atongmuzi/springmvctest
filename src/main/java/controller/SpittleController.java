package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Service.SpittleResposiory;


@Controller
@RequestMapping("/spittles")
public class SpittleController {
    public SpittleResposiory spittleResposiory;
    @Autowired
    public SpittleController(SpittleResposiory spittleResposiory){
        this.spittleResposiory = spittleResposiory;

    }
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList",spittleResposiory.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }
}
