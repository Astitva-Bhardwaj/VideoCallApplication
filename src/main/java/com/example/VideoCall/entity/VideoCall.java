package com.example.VideoCall.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.List;


@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video_calls")
public class VideoCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String callId;

    @ManyToOne
    @JoinColumn(name = "user_id") // Name of the foreign key column in the video_calls table
    private User user; // User who created the video call

    // Constructors, getters, setters
}
