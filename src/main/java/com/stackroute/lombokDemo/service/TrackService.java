package com.stackroute.lombokDemo.service;

import com.stackroute.lombokDemo.domain.Track;
import com.stackroute.lombokDemo.exceptions.CRUDException;
import org.graalvm.compiler.lir.LIRInstruction;


import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws CRUDException;

    public List<Track> getAlltracks();

    public Track updateTrack(Track track) throws CRUDException;

    public void deleteTrack(int id)throws CRUDException;
}
