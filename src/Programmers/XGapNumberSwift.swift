func solution(_ x:Int, _ n:Int) -> [Int64] {
    var answer: [Int64] = []
    answer.append(Int64(x))
    for index in 1..<n {
        answer.append(answer[index - 1] + Int64(x))
    }
    return answer
}
