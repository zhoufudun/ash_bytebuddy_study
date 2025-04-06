package com.example.webdemo.req;



import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.sql.DataSourceDefinition;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhoufudun
 * @date 2024/10/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExecRptQueryRe2  extends PaginationReq{

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date since_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date to_date;

}
