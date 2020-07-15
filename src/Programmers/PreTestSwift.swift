import Foundation

func solution(_ answers:[Int]) -> [Int] {
    var oneResult = 0
    var twoResult = 0
    var threeResult = 0
    
    let oneAnswer = [1, 2, 3, 4, 5]
    let twoAnswer = [2, 1, 2, 3, 2, 4, 2, 5]
    let threeAnswer = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for index in 0..<answers.count {
        if(answers[index] == oneAnswer[index % oneAnswer.count]) {
            oneResult += 1
        }
        if(answers[index] == twoAnswer[index % twoAnswer.count]) {
            twoResult += 1
        }
        if(answers[index] == threeAnswer[index % threeAnswer.count]) {
            threeResult += 1
        }
    }
    
    var max = 0
    max = (max < oneResult) ? oneResult : max
    max = (max < twoResult) ? twoResult : max
    max = (max < threeResult) ? threeResult : max
    
    var answer: [Int] = []
    if(max == oneResult) {
        answer.append(1)
    }
    if(max == twoResult) {
        answer.append(2)
    }
    if(max == threeResult) {
        answer.append(3)
    }
    
    return answer
}
