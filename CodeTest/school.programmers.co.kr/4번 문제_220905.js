function solution(a, b) {
	var map = ['SUN','MON','TUE','WED','THU','FRI','SAT'];
	var date = new Date('2016',a-1,b);
	var answer = date.getDay();
	return map[answer];
}