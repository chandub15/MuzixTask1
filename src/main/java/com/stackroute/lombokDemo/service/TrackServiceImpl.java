package com.stackroute.lombokDemo.service;

import com.stackroute.lombokDemo.domain.Track;
import com.stackroute.lombokDemo.exceptions.CRUDException;
import com.stackroute.lombokDemo.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//added new after error
public class TrackServiceImpl  implements  TrackService{

    private  TrackRepository trackRepository;
    private Track track;

    @Autowired
    public  TrackServiceImpl(TrackRepository trackRepository) throws CRUDException{
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track)throws CRUDException{
        this.track=track;
        if(trackRepository.existsById(track.getId())) {
            throw new CRUDException("user already exists");

        }
        Track savedTrack=trackRepository.save(track);
        if(savedTrack==null){
            throw new CRUDException("user already exists");
        }
        return  savedTrack;
    }

    @Override
    public List<Track> getAlltracks() {
        return  trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track)throws CRUDException {
        Track updateTrack;
        if(trackRepository.existsById(track.getId())) {
            updateTrack=trackRepository.save(track);
        }
        else{
            throw new CRUDException("Id not found");
        }
        return  updateTrack;
    }

    @Override
    public void deleteTrack(int id) throws CRUDException {

        if(trackRepository.existsById(track.getId())){
            trackRepository.deleteById(track.getId());

        }
        else{
            throw new CRUDException("track not found");
        }
    }


}
