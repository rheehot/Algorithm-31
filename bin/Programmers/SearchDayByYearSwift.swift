func solution(_ a:Int, _ b:Int) -> String {
    let dayNum = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    let day = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    
    var days = 0
    for index in 0..<a {
        days += dayNum[index]
    }
    
    days += b
    days %= 7
    
    return day[days]
}
