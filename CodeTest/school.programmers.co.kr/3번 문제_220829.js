/**
1~45 숫자 중 6개
1:6
2:5
3:4
4:3
5:2
6:그외

당첨:[31,	10,	45,	1,	6, 	19]
민우:[44,	1,	0,	0,	31,	25]
정리:[31,	0,	44,	1,	0,	25]

현재 맞은건 2개고
낙서된 숫자가 2개

결과 [3, 5]
최고 순위 3등
최소 순위 5등

win_nums[1~45]	length=6
lottos[0~45]	length=6

원소가 0이면 낙서된 알 수 없는 번호

무조건 length는 6
0을 제외하고 중복을 허용하지 않는다.(상관없음 테스트케이스)

정렬되어 있지 않아도 됨
**/

var lottos = [44,1,0,0,31,25];
var win_nums = [31,10,45,1,6,19];

function solution(lottos, win_nums) {
    var answer = [];
	var unknown = 0;
	var score = 0;
	for(var i=0;i<lottos.length;i++){
		if(lottos[i]==0){
			unknown++;
		}
	}
	console.log('unknown');
	console.log(unknown);
	
	
	for(var i=0;i<lottos.length;i++){
		for(var j=0;j<win_nums.length;j++){
			if(lottos[i]==win_nums[j]){
				score++;
				console.log('score up');
				console.log(score);
				win_nums[j] = 'X';
			}
		}
	}
	
	console.log('score');
	console.log(score);
	
	var min = score;
	console.log(min);
	var max = score+unknown;	
	console.log(max);
	
	answer.push(getRank(max));
	answer.push(getRank(min));
	return answer;
}

function getRank(score){
	if(score==6) return 1;
	else if(score==5) return 2;
	else if(score==4) return 3;
	else if(score==3) return 4;
	else if(score==2) return 5;
	else return 6;
}






























