package com.log.analyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    // jar 배포용 경로
//    String inputLogPath = "./input.log";
//    String outputLogPath = "./output.log";

    /**
     * input.log 파일을 읽어서 한 줄씩 리스트에 담아 반환합니다.
     * @return
     */
    static List<String> readToList() {
        //long startTime = System.currentTimeMillis();
        // 파일이 있는지 확인하고 없으면 널을 반환합니다.
        Path paths = Paths.get(inputLogPath);
        if(!Files.exists(paths)) {
            System.out.println("input.log not exists !!!");
            return null;
        }

        try {
            return Files.readAllLines(paths,StandardCharsets.UTF_8);
        } catch(IOException ioe) {
            System.out.println("logWrite IOException - " + ioe.getMessage());
        } finally {
            //System.out.println("it takes "+ (System.currentTimeMillis()-startTime)/1000.0+"s");
        }
        return null;
    }

    /**
     * 문자열 파라미터를 받아서 output.log 파일을 생성합니다.
     * @param content
     */
    static void write(String content) {
        //long startTime = System.currentTimeMillis();
        if(content.isEmpty()) return;
        // 파일이 있는지 확인하고 있으면 지우고 새 파일을 생성합니다.
        File file = new File(outputLogPath);
        if(file.exists()) file.delete();

        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            System.out.println("output.log was created!!!");
        } catch(IOException ioe) {
            System.out.println("logWrite IOException - " + ioe.getMessage());
        } finally {
            //System.out.println("it takes "+ (System.currentTimeMillis()-startTime)/1000.0+"s");
        }
    }
}
