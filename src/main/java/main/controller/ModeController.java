package main.controller;

import main.request.ModeRequest;
import main.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mode")
public class ModeController {
    @Autowired
    public ModeService modeService;


    @GetMapping("/all")
    public List<ModeRequest> findAll() {

        return modeService.findAll();
    }

    @GetMapping("/{id}")
    public ModeRequest findById(@PathVariable("id") int id) {
        return modeService.findbyId(id);
    }

    @PostMapping
    public String create(@RequestBody ModeRequest modeRequest){
        return modeService.create(modeRequest);
    }


}
