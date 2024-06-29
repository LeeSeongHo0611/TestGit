package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        System.out.println("/ 맵핑");
        return "Model & View";
    }

    @RequestMapping("/test1")
    public String test1(Model model) {
        // Model 객체를 이용해서, view로 Data 전달
        // 데이터만 설정이 가능
        System.out.println("/test1 맵핑");
        model.addAttribute("name", "홍길동");
        return "mytest"; // JSP 파일의 이름 (확장자 및 경로는 생략)
    }

    @RequestMapping("/mv")
    public ModelAndView test2() {
        // 데이터와 뷰를 동시에 설정이 가능
        System.out.println("/mv 맵핑");
        ModelAndView mv = new ModelAndView();

        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        mv.addObject("lists", list);
        mv.addObject("ObjectTest", "테스트입니다.");
        mv.addObject("name", "홍길동");
        mv.setViewName("myView"); // JSP 파일의 이름 (확장자 및 경로는 생략)

        return mv;
    }
}
