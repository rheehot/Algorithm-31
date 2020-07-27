import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    let t = d.sorted()
    
    var sum = 0
    var count = 0
    
    for tt in t {
        if sum + tt > budget {
            break
        }
        sum += tt
        count += 1
    }
    
    return count
}
