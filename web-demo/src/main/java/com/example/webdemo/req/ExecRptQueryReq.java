package com.example.webdemo.req;



import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhoufudun
 * @date 2024/10/29
 */
public class ExecRptQueryReq {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime since_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime to_date;

    public LocalDateTime getSince_date() {
        return since_date;
    }

    public void setSince_date(LocalDateTime since_date) {
        this.since_date = since_date;
    }

    public LocalDateTime getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDateTime to_date) {
        this.to_date = to_date;
    }
}
