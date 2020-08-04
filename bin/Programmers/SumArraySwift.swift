func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    let row = arr1.count
    let col = arr1[0].count
    
    var answer: [[Int]] = []
    for i in 0..<row {
        var temp: [Int] = []
        for j in 0..<col {
            temp.append(arr1[i][j] + arr2[i][j])
        }
        answer.append(temp)
    }
    return answer
}
