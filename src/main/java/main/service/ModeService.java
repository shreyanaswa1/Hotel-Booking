package main.service;

import main.entity.Mode;
import main.repository.ModeRepository;
import main.request.ModeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModeService {

    @Autowired
    private ModeRepository modeRepository;

    public List<ModeRequest> findAll(){
        List<Mode> modeList = modeRepository.findAll();
        List<ModeRequest> modeRequests = new ArrayList<ModeRequest>();
        for(Mode modes: modeList){
            ModeRequest modeRequest = new ModeRequest();
            modeRequest.setId(modes.getId());
            modeRequest.setType(modes.getType());
            modeRequests.add(modeRequest);
        }
        return modeRequests;

    }
    public ModeRequest findbyId(int id){
        Optional<Mode> modes  = modeRepository.findById(id);
        ModeRequest modeRequest = new ModeRequest();
        if(modes.isPresent()){
            modeRequest.setId(modes.get().getId());
            modeRequest.setType(modes.get().getType());
        }
        return modeRequest;
    }
    public String create(ModeRequest modeRequest) {
        Mode mode = new Mode();
        mode.setId(modeRequest.getId());
        mode.setType(modeRequest.getType());
        modeRepository.save(mode);
        return "Success";
    }
}
