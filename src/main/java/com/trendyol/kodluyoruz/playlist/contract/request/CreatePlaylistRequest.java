package com.trendyol.kodluyoruz.playlist.contract.request;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class CreatePlaylistRequest {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private String userId;
}
