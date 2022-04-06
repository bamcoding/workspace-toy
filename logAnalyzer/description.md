test project 

기능 구현을 위해 생성한 파일은 총 3개 입니다.
1. LogApplicationMain.java
2. LogServiceImpl.java
3. FileUtils.java

1. LogApplicationMain.java
역할 상세: 구현된 메소드를 호출합니다.

메소드 목록
- main : 구현된 메소드를 3단계로 호출합니다.

2. LogServiceImpl.java
역할 상세: 읽어들인 문자열을 읽고 집계하여 출력 포멧에 맞게 결과를 생성합니다. 

메소드 목록
- makeOutputLogForAnalyze : 문자열을 나눠서 집계합니다.
- getApikeyResult : apikey의 값을 집계합니다.
- getApiServiceIdResult : api service id의 값을 집계합니다.
- getWebBrowserResult : web browser의 값을 집계합니다.
- sortDescTotalList : 집계된 map을 받아서 내림차순 정렬된 map list를 반환합니다.
- countValue : 문자열에서 key가 발견된 개수만큼 값을 증가시킵니다. 

사용한 Java API
- java.util.*

3. FileUtils.java
역할 상세: 파일 IO를 이용해 파일을 읽거나 생성합니다.

메소드 목록
- readToList : input.log파일을 읽어서 라인별 List<String>으로 반환합니다.
- write : 문자열을 받아서 output.log파일을 생성합니다.

사용한 Java API
- java.io.*
- java.nio.*

