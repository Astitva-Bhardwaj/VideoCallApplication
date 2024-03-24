package com.example.VideoCall.service;

import com.example.VideoCall.entity.VideoCall;

public interface VideoCallService {
    VideoCall createVideoCall(VideoCall videoCall);

    VideoCall joinVideoCall(String callId);
}
