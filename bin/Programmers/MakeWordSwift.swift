func solution(_ s:String) -> String {
    let lowCase = s.lowercased()
    let upCase = s.uppercased()
    
    var answer = ""
    var i = 0
    for index in 0..<s.count {
        var temp = s[s.index(s.startIndex, offsetBy: index)]
        if (temp == " ") {
            answer.append(" ")
            i = 0
            continue
        }
        
        if (i % 2 == 0) {
            if (temp >= "a" && temp <= "z") {
                answer.append(upCase[s.index(s.startIndex, offsetBy: index)])
            }
            else {
                answer.append(temp)
            }
        }
        else {
            if (temp >= "A" && temp <= "Z") {
                answer.append(lowCase[s.index(s.startIndex, offsetBy: index)])
            }
            else {
                answer.append(temp)
            }
        }
        i += 1
    }
    return answer
}
