/**
1. 전체 학생의 수는 2~30명
2. 체육복 도난당한 학생은 1~N명 중복 도난 없음
3. 여벌의 체육복 가져온 학생은 1~N명 중복 여벌 없음
4. 여벌 체육복을 가져온 학생이 체육복을 도난당할 수 있다.
*/
//5 [2,4] [4,5] 4 

function solution(n, lost, reserve) {
    var answer = 0;
    let before = 1;
    for(let i=0;i<n;i++){
        if(lost.indexOf(i+1) > -1 && reserve.indexOf(i+1) > -1){
            answer++;
            before = 1;
        } else if(reserve.indexOf(i+1) > -1){
            if(before==0) {
                answer+=2;
                before = 1;    
            } else {
                answer++;
                before = 2;    
            }
        } else if(lost.indexOf(i+1) > -1){
            if(before==2) {
                answer++;
                before = 1;    
            } else {
                before = 0;    
            }
        } else {
            answer++;
            before=1;
        }
    }
    
    return answer;
}
