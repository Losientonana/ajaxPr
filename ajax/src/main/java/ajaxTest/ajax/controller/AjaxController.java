package ajaxTest.ajax.controller;

import ajaxTest.ajax.dto.AjaxDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AjaxController {

    @GetMapping("/ex01")
    public String ex01(){
        log.info("ex01");
        return "index";
    }
    @ResponseBody
    @PostMapping("/ex02")
    public String ex02(){
        log.info("ex02");
        return "안녕하세요";
    }
    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex03메서드 호출 완료";
    }


    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex04메서드 호출 완료";
    }

    @GetMapping("/ex05")
    public @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO){
        log.info("ajaxDTO = {}",ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex06")
    public @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO){
        log.info("ajaxDTO = {}",ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex07")
    public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO){
        log.info("ajaxDTO = {}",ajaxDTO);
        return ajaxDTO;
    }

    private List<AjaxDTO> DTOList(){
        List<AjaxDTO> dtolist = new ArrayList<>();
        dtolist.add(new AjaxDTO("data1","data11"));
        dtolist.add(new AjaxDTO("data2","data22"));
        return dtolist;

    }
    @PostMapping("/ex08")
    public @ResponseBody List<AjaxDTO> ex08(@ModelAttribute AjaxDTO ajaxDTO){
        log.info("ajaxDTO = {}",ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return dtoList;
    }

    @PostMapping("/ex09")
    public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

}
