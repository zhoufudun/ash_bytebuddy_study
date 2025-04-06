package com.example.webdemo.req;

import lombok.Data;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PaginationReq {

    @Min(0)
    private int start = 0;

    @Range(min = 1, max = 100)
    private int limit = 20;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date since_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date to_date;
}
