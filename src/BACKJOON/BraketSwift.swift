import Swift
import Foundation

while(true) {
    let str = readLine()!
    if str == "." {
        break
    }
    
    var a: [Character] = []
    var flag = true
    for i in 0..<str.count {
        let c = str[str.index(str.startIndex, offsetBy: i)]
        
        if c == "(" || c == "[" {
            a.append(c)
        }
        else if c == ")" {
            if a.isEmpty || a.last != "(" {
                flag = false
                break
            }
            
            a.removeLast()
        }
        else if c == "]" {
            if a.isEmpty || a.last != "[" {
                flag = false
                break
            }
            
            a.removeLast()
        }
    }
    
    if flag {
        if a.isEmpty {
            print("yes")
        }
        else {
            print("no")
        }
    }
    else {
        print("no")
    }
}
