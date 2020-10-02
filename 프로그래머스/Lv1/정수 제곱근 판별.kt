class Solution {
    fun solution(n: Long): Long {
        var num: Long = 1

        while(num < Math.sqrt(n.toDouble())+1){
            if(num*num == n) return (num+1) * (num+1)
            num++
        }

        return -1
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(121))
}