package com.imooc.service;

import com.imooc.Entity.Girl;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> findGirlList() {

        return girlRepository.findAll();
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }

    public Girl girlAdd(Girl girl) {
       return  girlRepository.save(girl);
    }

    public List<Girl> findByAge(Integer age) {
        return girlRepository.findByAge(age);
    }

    public Girl girlUpdate(Girl girl) {

        return girlRepository.save(girl);
    }

    public void deleteGirl(Integer id) {
        girlRepository.delete(id);
    }

    @Transactional
    public String operatorMore() {
        Girl girl1 = new Girl();
        girl1.setAge(100);
        girl1.setCupSize("qq");
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setAge(200);
        girl2.setCupSize("ww");
        girlRepository.save(girl2);

        Girl girl3 = new Girl();
        girl3.setAge(300);
        girl3.setCupSize("EE");
        girlRepository.save(girl3);
        return "success";
    }
}
