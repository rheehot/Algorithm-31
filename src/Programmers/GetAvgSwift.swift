func solution(_ arr:[Int]) -> Double {
    var sum = 0.0
    for a in arr {
        sum += Double(a)
    }
    
    return (sum / Double(arr.count))
}
