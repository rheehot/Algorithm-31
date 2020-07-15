import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var students = [Int](repeating: 0, count: n + 1)
    for l in lost {
        students[l] -= 1
    }
    for r in reserve {
        students[r] += 1
    }
    
    for index in 1..<students.count {
        if(students[index] > 0) {
            if(students[index - 1] < 0) {
                students[index - 1] += 1
                students[index] -= 1
            }
            else if(index + 1 < students.count && students[index + 1] < 0) {
                students[index + 1] += 1
                students[index] -= 1
            }
        }
    }
    
    var answer = 0
    for index in 1..<students.count {
        if(students[index] >= 0) {
            answer += 1
        }
    }
    
    return answer
}
