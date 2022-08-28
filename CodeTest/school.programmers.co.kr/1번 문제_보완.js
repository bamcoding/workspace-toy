//https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=javascript
function solution(answers) {
    var spj = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ];

    var score = [0,0,0];
    var index = [0,0,0];
    var answer = [];

    for(a in answers){
        if(answers[a] == spj[0][index[0]]) score[0]++;
        if(answers[a] == spj[1][index[1]]) score[1]++;
        if(answers[a] == spj[2][index[2]]) score[2]++;

        index[0]++;
        index[1]++;
        index[2]++;

        if(index[0]>=spj[0].length) index[0] = 0;
        if(index[1]>=spj[1].length) index[1] = 0;
        if(index[2]>=spj[2].length) index[2] = 0;
    }

    //최고값을 구한다.
    var max = 0;
    for(var i=0;i<score.length;i++){
        if(max <= score[i]){
            max = score[i];
        }
    }
    console.log("최고점수");
    console.log(max);

    //최고값과 일치하느 값의 인덱스를 순서대로 뽑는다.
    var aIndex = 0;
    for(var i=0;i<score.length;i++){
        if(max == score[i]){
            answer[aIndex]=i+1;
            aIndex++;
        }
    }

    return answer;
    
    //느낀점... 역시 문제를 이해하기가 제일 어렵다 빌런문제나 다름없다 이건
}