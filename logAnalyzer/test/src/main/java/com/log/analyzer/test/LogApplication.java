package com.log.analyzer.test;

import java.util.List;

public class LogApplication {
    public static void main(String[] args) {
        LogService logService = new LogServiceImpl();
        List<LogVO> logVOList = logService.logRead();
        logService.logProcessor(logVOList);
        System.out.println("output result : " + logService.logWrite(logVOList));


    }
}
