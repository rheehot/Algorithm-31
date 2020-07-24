import Foundation

func solution(_ n:Int64) -> Int64 {
    let temp = String(sqrt(Double(n))).split(separator: ".").last
    if temp == "0" {
        let num = Int(sqrt(Double(n))) + 1
        return Int64(num * num)
    }
    else {
        return -1
    }
}
