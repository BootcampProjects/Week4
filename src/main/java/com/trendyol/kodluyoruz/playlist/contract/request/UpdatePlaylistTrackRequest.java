package com.trendyol.kodluyoruz.playlist.contract.request;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class UpdatePlaylistTrackRequest {
    @NonNull
    private String name;
    @NonNull
    private String length;
    @NonNull
    private String artist;
}
