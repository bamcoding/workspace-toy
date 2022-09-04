
function solution(nums) {
	var takeCnt = nums.length/2; 
	
	//중복제거
	for(var i=0;i<nums.length;i++){
			for(var j=i+1;j<nums.length;j++){
					if(nums[i]==nums[j]){
							nums[j] = 'x';
					}
			}
	} 
	
	nums = nums.filter(n=>n!='x');
	return nums.length > takeCnt ? takeCnt : nums.length;
}