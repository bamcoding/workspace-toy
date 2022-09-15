//  n   result
//  10	3
//  12	11

function solution(n) {
    for(var i=1;i<n;i++){
        if(n % i==1){
            return i;
        }
    }
}
