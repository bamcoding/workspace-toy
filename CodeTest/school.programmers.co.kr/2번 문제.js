//https://school.programmers.co.kr/learn/courses/30/lessons/12906
//코딩테스트 연습 > 스텍/큐 > 같은숫자는 싫어
function solution(arr)
{
    var answer = [];

    for(var i=0;i<arr.length;i++){
        if(i>0 && arr[i] == arr[i-1]){
            continue;
        }else{
            answer.push(arr[i]);
        }
    }

    return answer;
}