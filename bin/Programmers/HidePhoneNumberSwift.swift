func solution(_ phone_number:String) -> String {
    var answer = ""
    let len = phone_number.count
    for index in 0..<len {
        if index < len - 4 {
            answer += "*"
        }
        else {
            answer.append(phone_number[phone_number.index(phone_number.startIndex, offsetBy: index)])
        }
    }
    return answer
}
