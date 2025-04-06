package com.example.webdemo.conterller;

import com.example.webdemo.conditionOnExpressionTest.ConditionOnExpressionTest;
import com.example.webdemo.req.ExecRptQueryRe2;
import com.example.webdemo.req.ExecRptQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.joda.time.DateTime;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class TestController {

    @Autowired
    private ConditionOnExpressionTest conditionOnExpressionTest;;

    @GetMapping("/getList")
    public ResponseEntity getList(@ModelAttribute @Valid ExecRptQueryReq req) {
        LocalDateTime sinceDate = req.getSince_date();
        LocalDateTime toDate = req.getTo_date();
        System.out.println(sinceDate);
        System.out.println(sinceDate.isBefore(toDate));
        System.out.println(Duration.between(sinceDate, toDate).getSeconds()<=3600);
        return sinceDate == null? null : ResponseEntity.ok(sinceDate);
    }

    @GetMapping("/getList2")
    public ResponseEntity getList2(@ModelAttribute @Valid ExecRptQueryRe2 req) {
        Date sinceDate = req.getSince_date();
        Date toDate = req.getTo_date();
        System.out.println(sinceDate);
        DateTime dateTime = new DateTime(sinceDate);
        System.out.println(dateTime);
        System.out.println(dateTime.plusDays(1).toDate());
        System.out.println(toDate.getTime()-sinceDate.getTime());
        return ResponseEntity.ok(sinceDate);
    }
}
