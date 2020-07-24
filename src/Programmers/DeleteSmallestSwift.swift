import Foundation
func solution(_ arr:[Int]) -> [Int] {
    if arr.count < 2 {
        return [Int](repeating: -1, count: 1)
    }
    
    var min = Int.max
    for a in arr {
        if a < min {
            min = a
        }
    }
    
    var answer: [Int] = []
    for a in arr {
        if a == min {
            continue
        }
        answer.append(a)
    }
    return answer
}
