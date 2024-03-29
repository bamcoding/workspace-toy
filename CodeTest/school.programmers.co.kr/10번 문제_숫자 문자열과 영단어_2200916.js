/**
입출력 예
s	                result
"one4seveneight"	1478
"23four5six7"	    234567
"2three45sixseven"	234567
"123"	            123
*/

function solution(s) {
    let answer = '';
    let numStr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
               
    let i=0;
    for(let j=1;j<=s.length;j++) {
        let numSplit = s.substr(i,j);
        if(numSplit.length == 1 && /[0-9]/.test(numSplit)){
            answer+=numSplit;
            s=s.slice(j,s.length)
            i=j=0;
        } 
        
        if(numStr.indexOf(numSplit) > -1){
            answer+= numStr.indexOf(numSplit);
            s=s.slice(j,s.length)
            i=j=0;
        }
    }
    
    return Number(answer);
}
