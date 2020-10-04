class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var sum = 0
        x.toString().map {
            sum += it-'0'
        }
        if(x%sum == 0) answer = true
        else answer = false

        return answer
//        return x % x.toString().fold(0){acc, c -> acc + c.toInt() - 48} == 0
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(10))
}