import Foundation

func solution(_ s:String) -> Bool
{
    var pNum = 0
    var yNum = 0
    
    let str = s.lowercased()
    for i in 0..<str.count {
        let tempChar = str[str.index(str.startIndex, offsetBy: i)]
        if tempChar == "p" {
            pNum += 1
        }
        if tempChar == "y" {
            yNum += 1
        }
    }
    
    if (pNum == yNum) {
        return true
    }
    else {
        return false
    }
}
