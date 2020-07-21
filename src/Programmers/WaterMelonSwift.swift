func solution(_ n:Int) -> String {
    let format = "수박"
    var answer = ""
    for i in 0..<n/2 {
        answer += format
    }
    if n % 2 != 0 {
        answer += "수"
    }
    return answer
}
