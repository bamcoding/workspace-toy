package com.log.analyzer;

import java.util.List;

public class LogApplicationMain {
    public static void main(String[] args) {
        //1. input.log 파일을 읽어서 한 줄씩 리스트에 담아 반환합니다.
        List<String> lines = FileUtils.readToList();
        //2. output.log 파일에 담을 내용을 생성합니다.
        String content = new LogServiceImpl().makeOutputLogForAnalyze(lines);
        //3. output.log 파일을 생성합니다.
        FileUtils.write(content);
    }
}
