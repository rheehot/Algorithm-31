func solution(_ s:String) -> String {
    var result: String = ""
    
    if(s.count % 2 == 0) {
        result.append(s[s.index(s.startIndex, offsetBy: s.count / 2 - 1)])
        result.append(s[s.index(s.startIndex, offsetBy: s.count / 2)])
    }
    else {
        result.append(s[s.index(s.startIndex, offsetBy: s.count / 2)])
    }
    return result
}
