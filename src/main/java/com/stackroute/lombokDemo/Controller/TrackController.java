package com.stackroute.lombokDemo.Controller;

import com.stackroute.lombokDemo.domain.Track;
import com.stackroute.lombokDemo.exceptions.CRUDException;
import com.stackroute.lombokDemo.exceptions.CRUDException;
import com.stackroute.lombokDemo.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {


    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<Track>(track, HttpStatus.CREATED);
        }catch (CRUDException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAlltracks(),HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<String>("Comment updated", HttpStatus.CREATED);
        }catch (CRUDException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable int id){
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(id);
            responseEntity=new ResponseEntity<String>("Track deleted", HttpStatus.CREATED);
        }catch (CRUDException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
