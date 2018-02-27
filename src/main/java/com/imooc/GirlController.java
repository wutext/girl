package com.imooc;

import com.imooc.Entity.Girl;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/findGirl")
    public Girl findOne(@RequestParam("id") Integer id) {
        return girlService.findOne(id);
    }

    @GetMapping(value = "/findGirls")
    public List<Girl> findGirlList() {
         return girlService.findGirlList();
    }

    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlService.girlAdd(girl);
    }

    @GetMapping(value = "/girlByAge")
    public List<Girl> findByAge(@RequestParam("age") Integer age) {

        return girlService.findByAge(age);
    }

    @PutMapping(value = "/updateGirl/{id}")
    public Girl updateByAge(@PathVariable("id") Integer id,
                            @RequestParam("age") Integer age,
                            @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlService.girlUpdate(girl);
    }

    @DeleteMapping("/deleteGirl/{id}")
    public String deleteGirl(@PathVariable("id") Integer id, HttpServletRequest request) {

        girlService.deleteGirl(id);
        System.out.printf(request.getServletPath()+"..");
        return "redirect:+"+request.getRequestURI()+"/findGirls";
    }

    @PutMapping("/tran")
    public String isSuccess() {

        return girlService.operatorMore();
    }

}
