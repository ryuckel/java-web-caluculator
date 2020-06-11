package com.example.demo.controller;
import com.example.demo.model.FDat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculateController {
    @GetMapping("/input")
    public String input(Model model){
        model.addAttribute("fdat", new FDat());
        return "tmp_input";
    }
    @PostMapping("result")
    public String result(@ModelAttribute FDat fdat, Model model){
        calculate(fdat);
        model.addAttribute("fdat", fdat);
        return "tmp_result";
    }

    private void calculate(FDat fdat){
        double ans = 0;
        int num1 = fdat.getNum1();
        int num2 = fdat.getNum2();
        String ope = fdat.getOpe();
        if (ope.equals("+")){
            ans = num1 + num2;
        } else if (ope.equals("-")){
            ans = num1 - num2;
        } else if (ope.equals("×")){
            ans = num1 * num2;
        } else if (ope.equals("÷")){
            ans = num1 / num2;
        }
        fdat.setAns(ans);

    }
}
