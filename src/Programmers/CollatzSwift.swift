func solution(_ num:Int) -> Int {
    var n = Int64(num)
    var count = 0
    
    while(n != 1) {
        if(n % 2 == 0) {
            n /= 2
        }
        else {
            n = n * 3 + 1
        }
        count += 1
        
        if (count > 500) {
            return -1
        }
    }
    return count
}
