package main.service;

import main.entity.mode;
import main.repository.ModeRepository;
import main.request.ModeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModeService {

    @Autowired
    ModeRepository modeRepository;

    public List<ModeRequest> findAll(){
        List<mode> modeList = modeRepository.findAll();
        List<ModeRequest> modeRequests = new ArrayList<ModeRequest>();
        for(mode modes: modeList){
            ModeRequest modeRequest = new ModeRequest();
            modeRequest.setId(modes.getId());
            modeRequest.setType(modes.getType());
            modeRequests.add(modeRequest);
        }
        return modeRequests;

    }
    public ModeRequest findbyId(int id){
        mode modes = modeRepository.findOne(id);
        ModeRequest modeRequest = new ModeRequest();
        modeRequest.setId(modes.getId());
        modeRequest.setType(modes.getType());

        return modeRequest;
    }
}
