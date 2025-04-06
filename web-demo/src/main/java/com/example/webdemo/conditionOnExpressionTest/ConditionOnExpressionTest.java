package com.example.webdemo.conditionOnExpressionTest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("'${gateway.fix.channel}' == 'HKEX' or '${gateway.fix.channel}' == 'SGX'")
public class ConditionOnExpressionTest {

}
