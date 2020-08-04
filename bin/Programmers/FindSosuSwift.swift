func solution(_ n:Int) -> Int {
    var answer = 0
    var sosu = [Bool](repeating: true, count: n + 1)
    
    for i in 2..<sosu.count {
        if sosu[i]{
            answer += 1
            
            var temp = 2
            while(true) {
                if i * temp >= sosu.count {
                    break
                }
                sosu[i * temp] = false
                temp += 1
            }
        }
    }
    
    return answer
}
