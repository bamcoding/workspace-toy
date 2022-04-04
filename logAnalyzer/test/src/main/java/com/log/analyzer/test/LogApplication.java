package com.log.analyzer.test;

import java.util.List;

public class LogApplication {
    public static void main(String[] args) {
        LogService logService = new LogServiceImpl();
        logService.logProcessor(logService.logRead());
        //System.out.println("output result : " + logService.logWrite(logVOList));


    }
}
