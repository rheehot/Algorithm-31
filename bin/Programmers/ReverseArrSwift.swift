func solution(_ n:Int64) -> [Int] {
    var answer: [Int] = []
    var temp = n
    while(temp > 0) {
        answer.append(Int(temp % 10))
        temp /= 10
    }
    return answer
}
