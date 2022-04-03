package com.log.analyzer.test;

import java.util.List;
import java.util.Map;

/*
* 본 코딩 테스트는 총 1문항으로 구성되어 있습니다.
* 각 문항에서 제시한 요구사항을 상세히 살펴주시고 주어진 기간 내 문제를 풀고 그 결과를 제출해주시면 됩니다.
*
* [진행 가이드]
* 제충되는 모든 소스는 컴파일과 실행이 가능한 코드여야 합니다.
* 상식적인 수준의 코딩 컨벤션과 자료구조의 적절한 사용 그리고 객체지향적 설계 능력이 주요 평가항목이 됩니다.
* 오픈소스 외부 라이브러리 사용없이 구현되어야 합니다.
* 인코딩 UTF-8
* JAVA8 이상
* */
public interface LogService {
    static final String logPath = "src/main/resources";
    static final String logFilePath = "src/main/resources/input.log";

    List<LogVO> logRead();

    Map<String,String> logProcessor(List<LogVO> logVOList);

    boolean logWrite(List<LogVO> logVOList);

}
