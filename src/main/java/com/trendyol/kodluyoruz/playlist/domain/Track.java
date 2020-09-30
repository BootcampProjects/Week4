package com.trendyol.kodluyoruz.playlist.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    private String id;
    private String name;
    private String length;
    private String artist;
}
