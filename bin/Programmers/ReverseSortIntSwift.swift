func solution(_ n:Int64) -> Int64 {
    if n <= 10 {
        return n
    }
    
    var temp: [Int] = []
    var t = n
    while(t > 0) {
        temp.append((Int)(t % 10))
        t /= 10
    }
    
    temp.sort()
    
    var answer: Int64 = 0
    var dist: Int64 = 1
    for i in 0..<temp.count {
        answer += ((Int64)(temp[i]) * dist)
        dist *= 10
    }
    
    return answer
}
