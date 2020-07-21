func solution(_ seoul:[String]) -> String {
    for index in 0..<seoul.count {
        if seoul[index] == "Kim" {
            var answer: String = "김서방은 "
            answer += String(index)
            answer += "에 있다"
            return answer
        }
    }
    return ""
}
