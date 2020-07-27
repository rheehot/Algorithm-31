// solve repeat
func solution(_ s:String, _ n:Int) -> String {
    var answer = String()
    let alphabet = ["A":0,"B":1,"C":2,"D":3,"E":4,"F":5,"G":6,"H":7,"I":8,"J":9,"K":10,"L":11,"M":12,"N":13,"O":14,"P":15,"Q":16,"R":17,"S":18,"T":19,"U":20,"V":21,"W":22,"X":23,"Y":24,"Z":25]
       let keys = alphabet.keys.sorted()
 
    for i in 0..<Array(s).count{
        if Array(s)[i] == " "{
            answer += " "
            continue
        }
            var number = alphabet[String(Array(s)[i].uppercased())]! + n
                                     if number > 25 {
                                     number = number - 26
                                              }
                                     let value = keys[number]
                                     let value1 = alphabet.index(forKey: value)
       if Array(s)[i].isUppercase{
            answer += alphabet.keys[value1!]
        }else {
            answer += alphabet.keys[value1!].lowercased()
        }
    }
    return answer
}

