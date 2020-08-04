func solution(_ x:Int) -> Bool {
    var num = x
    var sum = 0
    
    while(num > 0) {
        sum += (num % 10)
        num /= 10
    }
    
    if (x % sum == 0) {
        return true
    }
    else {
        return false
    }
}
