package com.stackroute.lombokDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.lombokDemo.domain.Track;
import org.springframework.stereotype.Repository;

//jpa is having crud menthods...we want to use crud operations pres in JpaRepo(interface)..
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

}
