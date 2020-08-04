func solution(_ s:String) -> Bool {
    if !(s.count == 4 || s.count == 6) {
        return false
    }
    
    for c in s {
        if (c >= "A" && c <= "z") {
            return false
        }
    }
    return true
}
