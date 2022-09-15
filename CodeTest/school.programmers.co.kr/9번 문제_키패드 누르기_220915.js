//0. 손위치 초기화
//1. 입력한 숫자의 위치를 리턴
//2. 특정 좌표는 무조건 L 리턴
//3. 특정 좌표는 무조건 R 리턴
//4. 입력된 숫자와 왼손엄지의 거리 계산
//5. 입력된 숫자와 오른손 엄지의 거리 계산
//6. 오른손 거리와 왼손 거리를 비교해서 L, R을 리턴하고 손위치 저장



function solution(numbers, hand) {
    let tMap = {
        1 : [0,3], 2 : [1,3], 3 : [2,3],
        4 : [0,2], 5 : [1,2], 6 : [2,2],
        7 : [0,1], 8 : [1,1], 9 : [2,1],
        '*':[0,0], 0 : [1,0], '#':[2,0]
    }

    //0. 손위치 초기화
    let left = tMap['*'];
    let right = tMap['#'];
    
    let result = '';
    for(let i=0;i<numbers.length;i++){
        
        //1. 입력한 숫자의 위치를 리턴
        let cp = tMap[numbers[i]];
        
       if(cp[0] == 0 && cp[1] != 0) {
            
            //2. 특정 좌표는 무조건 L 리턴    
            result+='L';
            left = cp;
            continue;
        
        } else if(cp[0] == 2 && cp[1] != 0) {
            
            //3. 특정 좌표는 무조건 R 리턴
            result+='R';
            right = cp;
            continue;
        }
        
        //4. 입력된 숫자와 왼손엄지의 거리 계산
        lDiff = Math.abs(cp[0]-left[0]) + Math.abs(cp[1]-left[1]);
               
        //5. 입력된 숫자와 오른손 엄지의 거리 계산
        rDiff = Math.abs(cp[0]-right[0]) + Math.abs(cp[1]-right[1]);
            
        //6. 오른손 거리와 왼손 거리를 비교해서 L, R을 리턴하고 손위치 저장
        if(lDiff<rDiff) {
            result+='L';
            left = cp;
        } else if (lDiff>rDiff) {
            result+='R';
            right = cp;
        } else {
            if(hand === 'left') {
                result+='L';
                left = cp;
            } else {
                result+='R';
                right = cp;
            }
        }
    }
    
    return result;
}
 
