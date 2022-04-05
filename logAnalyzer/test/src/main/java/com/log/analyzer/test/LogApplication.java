package com.log.analyzer.test;

public class LogApplication {
    public static void main(String[] args) {
        FileUtils.read();

        String content = new LogServiceImpl().makeRankString("");

        FileUtils.write(content);
    }
}
