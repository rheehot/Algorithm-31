func solution(_ strings:[String], _ n: Int) -> [String] {
    let answer = strings.sorted { (s1, s2) -> Bool in
        let c1 = s1[s1.index(s1.startIndex, offsetBy: n)]
        let c2 = s2[s2.index(s2.startIndex, offsetBy: n)]
        
        if c1 == c2 {
            return s1 < s2
        }
        return c1 < c2
    }
    return answer
}
