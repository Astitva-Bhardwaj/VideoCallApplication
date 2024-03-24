package com.example.VideoCall.service.impl;

import com.example.VideoCall.entity.VideoCall;
import com.example.VideoCall.repo.VideoCallRepository;
import com.example.VideoCall.service.VideoCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoCallServiceImpl implements VideoCallService {

    @Autowired
    private VideoCallRepository videoCallRepository;

    @Override
    public VideoCall createVideoCall(VideoCall videoCall) {
        return videoCallRepository.save(videoCall);
    }

    @Override
    public VideoCall joinVideoCall(String callId) {
        return videoCallRepository.findById(Long.parseLong(callId)).orElse(null);
    }
}
