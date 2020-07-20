func solution(_ a:Int, _ b:Int) -> Int64 {
    if(a == b) {
        return Int64(a)
    }
    
    let start = a > b ? b : a
    let end = a > b ? a : b
    
    var answer: Int64 = 0
    for i in start...end {
        answer += Int64(i)
    }
    return answer
}
