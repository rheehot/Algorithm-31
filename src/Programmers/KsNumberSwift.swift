import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var result:[Int] = []
    for command in commands {
        let i = command[0]
        let j = command[1]
        let k = command[2]
        
        var temp: [Int] = []
        for idx in (i - 1)..<j {
            temp.append(array[idx])
        }
        temp.sort()
        
        result.append(temp[k - 1])
    }
    
    return result
}
