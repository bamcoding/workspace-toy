package com.log.analyzer.test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

// 제출되는 모든 소스는 컴파일 & 실행 가능한 코드여야 합니다.
// 상식적인 수준의 코딩 컨벤션과 자료구조의 적절한 사용 그리고 객체지향적 설계능력이 주요 평가항목이 됩니다. 오픈소스 외부 라이브러리 사용없이 구현되어야 합니다. (불가피한 경우 부연설명을 꼭 포함해주세요.)
// 인코딩 : UTF-8
// 사용언어 : Java (Java8 이상)
// [입력 포멧]
// - 반드시 파일 I/O 처리를 해야 합니다.
// - 입력은 다음과 같은 형식의 input.log 파일로 전달되어야 합니다.
// [출력 포멧]
// - 반드시 파일 I/O 처리해야 합니다.
public interface FileUtils {
    String inputLogPath = "src/main/resources/input.log";
    String outputLogPath = "src/main/resources/output.log";

    static String read() {
        long startTime = System.currentTimeMillis();

        File file = new File(inputLogPath);

        if(!file.exists()) return "";


        return "";
    }

    static boolean write(String content) {
        long startTime = System.currentTimeMillis();

        try{
            //1. 파일이 있는지 확인하고 지웁니다.
            boolean isExist = Files.exists(Paths.get(outputLogPath));
            if(isExist) Files.delete(Paths.get(outputLogPath));

            //2. 새 파일을 생성합니다.
            OutputStream outputStream = Files.newOutputStream(Files.createFile(Paths.get(outputLogPath)));
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();//바로 쓰기
            outputStream.close();//시스템 메모리 해방
            return true;

        } catch(IOException ioe) {
            System.out.println("logWrite IOException - " + ioe.getMessage());
        }

        return false;
    }
}
