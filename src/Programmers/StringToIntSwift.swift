func solution(_ s:String) -> Int {
    if s[s.startIndex] == "+" {
        let range = s.index(after: s.startIndex)..<s.endIndex
        let temp: String = String(s[range])
        return Int(temp) ?? 0
    }
    else if s[s.startIndex] == "-" {
        let range = s.index(after: s.startIndex)..<s.endIndex
        let temp: String = String(s[range])
        return (Int(temp) ?? 0) * -1
    }
    else {
        return Int(s) ?? 0
    }
}
