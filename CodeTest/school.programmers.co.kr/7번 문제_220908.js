function solution(s){
    var result = 0
    for(var i=0;i<s.length;i++){
        if(s[i] == '(') {
            result++;   
        } else {
            result--;   
        }
        if(result < 0) break;
    }
    var answer = (result == 0) ? true : false;
    return answer;
}
