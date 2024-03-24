package com.example.VideoCall.repo;

import com.example.VideoCall.entity.User;
import com.example.VideoCall.entity.VideoCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCallRepository extends JpaRepository<VideoCall, Long> {

}
