func solution(_ s:String) -> String {
    var tempChar: [Character] = []
    for i in 0..<s.count {
        tempChar.append(s[s.index(s.startIndex, offsetBy: i)])
    }
    
    tempChar.sort()
    tempChar.reverse()
    
    var answer = ""
    for c in tempChar {
        answer.append(c)
    }
    return answer
}
