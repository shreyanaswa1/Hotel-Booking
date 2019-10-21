package main.controller;

import main.request.ModeRequest;
import main.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modes")
public class ModeController {
    @Autowired
    public ModeService modeService;


    @GetMapping("/all")
    public List<ModeRequest> findAll() {
        return modeService.findAll();
    }
    @GetMapping("/{id}")
    public ModeRequest findOne(@PathVariable("id") int id)
    {
        return modeService.findbyId(id);
    }





}
