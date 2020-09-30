package com.trendyol.kodluyoruz.playlist.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ExceptionDetail {
    private String description;
    private String message;
    private Date date;
}
