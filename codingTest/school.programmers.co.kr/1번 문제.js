function solution(answers) {
    var answer = [];
    score1 = getScoreSupoja1(answers);
    score2 = getScoreSupoja2(answers);
    score3 = getScoreSupoja3(answers);
    
    answer = getAnswer([score1, score2, score3]);
    return answer;
}

function getAnswer(scores){
    var answer = [];
    var originScores = [...scores];
    var sortedScores = [...getScoreDesc(scores)];
    console.log(originScores);
    console.log(sortedScores);
    console.log("시작");
    for(i in sortedScores){
        if(sortedScores[i]>0){
            console.log(originScores);
            var supojaNo = originScores.indexOf(sortedScores[i]);
            originScores[supojaNo]='X';
            answer.push(supojaNo+1);
        }
    }
    
    console.log("getAnswer");
    console.log(answer);
    return answer;
}

function getScoreDesc(scores){
    var temp;
    for(var i=0;i<scores.length-1;i++){
        for(var j=i+1;j<scores.length;j++){
            if(scores[i] < scores[j]){
                var temp = scores[i];
                scores[i] = scores[j];
                scores[j] = temp;
            }   
        }
    }
    return scores;
}

function getScoreSupoja1(answers){
    var score = 0;
    for(var i=1;i<=answers.length;i++) {
        if(i == answers[i-1]){
            score++;
        }
    }
    return score;
}

function getScoreSupoja2(answers){
    var supoja2 = [2, 1, 2, 3, 2, 4, 2, 5];
    
    var index = 0;
    while(supoja2.length < answers.length){
        supoja2.push(supoja2[index]);
        index++;
    }
    
    var score = 0;
    for(var i=0;i<answers.length;i++){
        if(supoja2[i]==answers[i]){
            score++;
        }
    }
    
    return score;
}

function getScoreSupoja3(answers){
    var supoja3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    var index = 0;
    while(supoja3.length < answers.length){
        supoja3.push(supoja3[index]);
        index++;
    }
    
    var score = 0;
    for(var i=0;i<answers.length;i++){
        if(supoja3[i]==answers[i]){
            score++;
        }
    }
    
    return score;
}
