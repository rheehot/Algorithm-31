
import Swift
import Foundation

func solution(_ n: Int) -> Int {
    var len = n
    var answer: Int = 0
    while(true) {
        if(len == 1 || len == 2) {
            answer += 1;
            break;
        }
        if(len % 2 != 0) {
            answer += 1
            len -= 1
        }
        len /= 2
    }
    return answer
}

print(solution(6))
